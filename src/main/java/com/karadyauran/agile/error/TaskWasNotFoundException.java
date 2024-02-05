package com.karadyauran.agile.error;

public class TaskWasNotFoundException extends RuntimeException
{
    public TaskWasNotFoundException(String message)
    {
        super(message);
    }
}
