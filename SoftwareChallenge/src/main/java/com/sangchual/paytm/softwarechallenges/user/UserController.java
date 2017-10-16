package com.sangchual.paytm.softwarechallenges.user;

import com.sangchual.paytm.softwarechallenges.exception.InvalidDataFormatException;
import com.sangchual.paytm.softwarechallenges.exception.ResourceConflictException;
import com.sangchual.paytm.softwarechallenges.exception.ResourceNotFoundException;
import com.sangchual.paytm.softwarechallenges.user.entity.User;
import com.sangchual.paytm.softwarechallenges.user.jpa.UserDAO;
import com.sangchual.paytm.softwarechallenges.utils.AuthTokenManager;
import com.sangchual.paytm.softwarechallenges.utils.EmailValdator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
public class UserController {
    @Autowired
    UserDAO userDao ;

    @Autowired
    EmailValdator emailValdator ;

    /**
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/service/v1/user", method = RequestMethod.PUT)
    @ResponseBody
    @CrossOrigin
    // public Result signup(@RequestParam("username") String username, @RequestParam("email") String email,@RequestParam("password") String password) {
    public Result signup(@RequestBody User user) {
        Result result = new Result() ;

        // input validation
        // non-empty value passed
        if(StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassword())) {
            throw new InvalidDataFormatException("all fields are required");
        }
        // validate email format
        if(!emailValdator.isValid(user.getEmail())) {
            throw new InvalidDataFormatException("invalid email format");
        }
        // never registered before
        if(userDao.exists(user.getEmail())) {
            throw new ResourceConflictException("the email has already been registered.");
        }

        userDao.append(user.getUsername(), user.getEmail(), user.getPassword());

        result.setCode(Result.SUCCESS);
        result.setMessage("sign up success");

        return result ;
    }

    @RequestMapping(value = "/service/v1/user", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Result signin(@RequestBody User user) {
        Result result = new Result() ;

        // input validation
        // non-empty value passed
        if(StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassword())) {
            throw new InvalidDataFormatException("all fields are required");
        }
        // validate email format
        if(!emailValdator.isValid(user.getEmail())) {
            throw new InvalidDataFormatException("invalid email format");
        }

        if(userDao.find(user.getEmail(), user.getPassword())) {
            result.setCode(Result.SUCCESS);
            result.setMessage("signin success");
            result.setAuthToken(AuthTokenManager.getInstance().createAuthToken(user));
        } else {
            throw new ResourceNotFoundException("failed to sign in with specified user credential.") ;
        }

        return result ;
    }

    @RequestMapping(value = "/service/v1/user/passwordreset", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Result updatePassword(@RequestBody User user) {
        Result result = new Result() ;

        // input validation
        // non-empty value passed
        if(StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassword())) {
            throw new InvalidDataFormatException("all fields are required");
        }
        // validate email format
        if(!emailValdator.isValid(user.getEmail())) {
            throw new InvalidDataFormatException("invalid email format");
        }
        // never registered before
        if(userDao.exists(user.getEmail())) {
            throw new ResourceConflictException("the email has already been registered.");
        }

        userDao.updatePassword(user.getEmail(), user.getPassword()) ;

        result.setCode(Result.SUCCESS);
        result.setMessage("password change success.");

        return result ;
    }
}
