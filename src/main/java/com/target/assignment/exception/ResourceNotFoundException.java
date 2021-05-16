package com.target.assignment.exception;

public class ResourceNotFoundException extends RuntimeException{

   public ResourceNotFoundException(String message){
      super(message);
   }
}
