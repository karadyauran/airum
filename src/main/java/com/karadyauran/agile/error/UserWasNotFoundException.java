package com.karadyauran.agile.error;

public class UserWasNotFoundException extends RuntimeException
{
    public UserWasNotFoundException(String message)
    {
        super(message);
    }
}
