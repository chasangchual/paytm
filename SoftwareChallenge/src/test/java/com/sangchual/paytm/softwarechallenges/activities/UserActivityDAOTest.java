package com.sangchual.paytm.softwarechallenges.activities;

import com.sangchual.paytm.softwarechallenges.Application;
import com.sangchual.paytm.softwarechallenges.user.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserActivityDAOTest {

    String email = "test.user@email.com" ;

    @Autowired
    private UserActivityService userActivityDAO ;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Before
    public void setUp() throws Exception {
        esTemplate.deleteIndex(UserActivity.class) ;
        esTemplate.createIndex(UserActivity.class) ;
        esTemplate.putMapping(UserActivity.class) ;
        esTemplate.refresh(UserActivity.class);
    }

    @Test
    public void save() throws Exception {
        UserActivity userActivity = userActivityDAO.save(new UserActivity().withEmail(email).withActivity(UserActivityType.SIGN_IN.getValue())) ;
        assertEquals(email, userActivity.getEmail()) ;
        assertEquals(UserActivityType.SIGN_IN.getValue(), userActivity.getActivity());
    }

    @Test
    public void findAll() throws Exception {
        userActivityDAO.save(new UserActivity().withEmail(email).withActivity(UserActivityType.SIGN_UP.getValue())) ;
        userActivityDAO.save(new UserActivity().withEmail(email).withActivity(UserActivityType.SEARCH.getValue())) ;

        Iterator<UserActivity> itr = userActivityDAO.findAll().iterator() ;
        int returned = 0 ;
        while(itr.hasNext()) {
            System.out.println(itr.next().toString()) ;
            returned ++ ;
        }
        assertEquals(2, returned);
    }

    @Test
    public void findByEmail() throws Exception {
        userActivityDAO.save(new UserActivity().withEmail(email).withActivity(UserActivityType.SIGN_UP.getValue())) ;
        userActivityDAO.save(new UserActivity().withEmail(email).withActivity(UserActivityType.SEARCH.getValue())) ;

        List<UserActivity> userActivites = userActivityDAO.findByEmail(email) ;
        assertEquals(2, userActivites.size());

        for(UserActivity userActivity : userActivites) {
            System.out.println(userActivity) ;
        }
    }

}