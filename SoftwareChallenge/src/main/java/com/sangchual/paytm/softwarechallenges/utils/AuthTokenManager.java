package com.sangchual.paytm.softwarechallenges.utils;

import com.sangchual.paytm.softwarechallenges.exception.InternalServerException;
import com.sangchual.paytm.softwarechallenges.exception.InvalidDataFormatException;
import com.sangchual.paytm.softwarechallenges.user.entity.User;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime ;
import java.util.Base64;

public class AuthTokenManager {
    private static AuthTokenManager instance = null ;

    // TO-DO get key string from external resource or encrypt with private key
    private final String KEY = "jdks" ;
    private final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss" ;

    public static synchronized AuthTokenManager getInstance() {
        if(instance == null) {
            instance = new AuthTokenManager();
        }
        return instance ;
    }

    private AuthTokenManager() {

    }

    public String createAuthToken(User user)  {
        StringBuilder inStr = new StringBuilder(user.getEmail()) ;
        inStr.append("|") ; inStr.append(expiryDateTimeString()) ;

        String encrypted = "" ;

        try {
            encrypted = Base64.getEncoder().encodeToString(encrypt(inStr.toString(), KEY).getBytes()) ;
        } catch (Exception e) {
            throw new InternalServerException("Exception occurred during auth token encryption") ;
        }

        return encrypted ;
    }

    public Boolean validateAuthToken(String email, String authToken) {
        String decrypted = null;

        try {
            decrypted = decrypt(Base64.getDecoder().decode(authToken), KEY);
        } catch (Exception e) {
            throw new InternalServerException("Exception occurred during base64 decoding") ;
        }

        String[] values = decrypted.split("|") ;
        if(values.length != 2) {
            throw new InvalidDataFormatException("invalid auth token passed - format error") ;
        }

        if(!email.equals(values[0])) {
            throw new InvalidDataFormatException("invalid auth token passed - email does not match") ;
        }

        DateTimeFormatter  formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT) ;
        LocalDateTime dateTime = LocalDateTime.parse(values[1], formatter);

        if(LocalDateTime.now().isAfter(dateTime)) {
            throw new InvalidDataFormatException("invalid auth token passed - expired token") ;
        }

        return Boolean.TRUE ;
   }

    private String expiryDateTimeString() {
        LocalDateTime now = LocalDateTime.now().plusHours(2) ;
        DateTimeFormatter  formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT) ;
        return now.format(formatter) ;
    }

    private String encrypt(String strClearText,String strKey) throws Exception{
        String strData="";

        try {
            SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
            Cipher cipher= Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
            byte[] encrypted=cipher.doFinal(strClearText.getBytes());
            strData=new String(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return strData;
    }

    private String decrypt(byte[] strEncrypted,String strKey) throws Exception{
        String strData="";

        try {
            SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
            Cipher cipher=Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, skeyspec);
            byte[] decrypted=cipher.doFinal(strEncrypted);
            strData=new String(decrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return strData;
    }
}
