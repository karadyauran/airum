package com.karadyauran.airum.error;

public class UsernameIsAlreadyExists extends RuntimeException
{
    public UsernameIsAlreadyExists(String message)
    {
        super(message);
    }
}
