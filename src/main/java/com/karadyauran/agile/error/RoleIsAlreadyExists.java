package com.karadyauran.agile.error;

public class RoleIsAlreadyExists extends RuntimeException
{
    public RoleIsAlreadyExists(String message)
    {
        super(message);
    }
}
