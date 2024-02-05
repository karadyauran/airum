package com.karadyauran.agile.error;

public class UsernameIsAlreadyExists extends RuntimeException
{
    public UsernameIsAlreadyExists(String message)
    {
        super(message);
    }
}
