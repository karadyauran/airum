package com.karadyauran.agile.error;

public class EmailIsAlreadyExists extends RuntimeException
{
    public EmailIsAlreadyExists(String message)
    {
        super(message);
    }
}
