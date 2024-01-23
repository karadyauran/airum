package com.karadyauran.agile.exception;

public class UserDoesntExistException extends Throwable
{
    public UserDoesntExistException(String message)
    {
        super(message);
    }
}
