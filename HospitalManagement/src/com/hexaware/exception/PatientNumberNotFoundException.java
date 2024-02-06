package com.hexaware.exception;

public class PatientNumberNotFoundException extends Exception {
	public PatientNumberNotFoundException() {
        System.out.println("invalid details ");
	}
        @Override
    	public String toString() {
    		return "Invalid patient Credentials!";
    	}
}
