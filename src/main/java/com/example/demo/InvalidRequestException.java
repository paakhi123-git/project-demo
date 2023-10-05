//Author: Paakhi Iyer
package com.example.demo;

public class InvalidRequestException extends Throwable {
    public InvalidRequestException(String message) {
        super(message);
    }
}