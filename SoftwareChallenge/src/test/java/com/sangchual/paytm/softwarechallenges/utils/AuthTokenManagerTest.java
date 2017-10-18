package com.sangchual.paytm.softwarechallenges.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class AuthTokenManagerTest {
    final String userEmail = "test.user@gmail.com" ;

    @Test
    public void createAuthToken() throws Exception {
        AuthTokenManager authTokenManager = AuthTokenManager.getInstance() ;
        String authToken  = authTokenManager.createAuthToken(userEmail) ;
        assertNotNull(authToken); ;
    }

    @Test
    public void validateAuthToken() throws Exception {
        AuthTokenManager authTokenManager = AuthTokenManager.getInstance() ;
        String authToken  = authTokenManager.createAuthToken(userEmail) ;
        assertTrue(authTokenManager.validateAuthToken(userEmail, authToken)) ;
    }

    @Test
    public void encrypt() throws Exception {
        AuthTokenManager authTokenManager = AuthTokenManager.getInstance() ;
        String encrypted = authTokenManager.encrypt(userEmail, authTokenManager.getKey()) ;
        assertNotNull(encrypted) ;
    }

    @Test
    public void decrypt() throws Exception {
        AuthTokenManager authTokenManager = AuthTokenManager.getInstance() ;
        String encrypted = authTokenManager.encrypt(userEmail, authTokenManager.getKey()) ;
        assertEquals(userEmail, authTokenManager.decrypt(encrypted, authTokenManager.getKey())) ;
    }
}