package com.peace.springNation.error;

public class DepartmentNotFoundException extends Exception{
    public DepartmentNotFoundException() {
        super();
    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }

    public DepartmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundException(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
//we are creating department not found error.
//first of all, we create a package; error and a
// class called DepartmentNotFoundException, extend exception and override d 5 methods before java.throwable
// go to the service implementation layer to the particular method you want to handle
//then make the method implementation an option ie Optional<Department> then put the if statement
    //return the value and add method signature to where needed
    //
    //after that create a new class to return all the exception statements
//
}
