package com.karadyauran.agile.exception;

public class TaskDoesntExistException extends Throwable
{
    public TaskDoesntExistException(String message)
    {
        super(message);
    }
}
