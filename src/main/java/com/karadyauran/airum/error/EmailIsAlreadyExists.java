package com.karadyauran.airum.error;

public class EmailIsAlreadyExists extends RuntimeException
{
    public EmailIsAlreadyExists(String message)
    {
        super(message);
    }
}
