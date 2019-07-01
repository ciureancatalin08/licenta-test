package com.example.dbservice.entity.message;


import com.example.dbservice.configuration.BussinesException;

public class MessageCatalog {

    /**
     * A message for the case when a user already exists with the same email.
     */
    public static final BussinesException USER_WITH_SAME_USERNAME_EXISTS
            = new BussinesException ("A user with the same username already exists");

    /**
     * A message for the case when user credentials for login are incorrect
     */
    public static final BussinesException USER_WITH_SAME_FINGERPRINT_EXISTS
            = new BussinesException ("A user with the same fingerprint already exists");

}