package com.example.loginservice.entity.message;


import com.example.loginservice.configuration.BussinesException;

public class MessageCatalog {

    /**
     * A message for the case when a user already exists with the same email.
     */
    public static final BussinesException USER_WITH_INVALID_CREDENTIALS
            = new BussinesException ("Bad credentials");

    /**
     * A message for the case when user credentials for login are incorrect
     */
    public static final BussinesException USER_WITH_SAME_FINGERPRINT_EXISTS
            = new BussinesException ("A user with the same fingerprint already exists");

}