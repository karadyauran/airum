package com.karadyauran.airum.error;

public class RoleIsAlreadyExists extends RuntimeException
{
    public RoleIsAlreadyExists(String message)
    {
        super(message);
    }
}
