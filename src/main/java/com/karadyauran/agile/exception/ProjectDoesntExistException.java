package com.karadyauran.agile.exception;

public class ProjectDoesntExistException extends Throwable
{
    public ProjectDoesntExistException(String message)
    {
        super(message);
    }
}
