package com.karadyauran.agile.error;

public class ProjectWasNotFoundException extends RuntimeException
{
    public ProjectWasNotFoundException(String message)
    {
        super(message);
    }
}
