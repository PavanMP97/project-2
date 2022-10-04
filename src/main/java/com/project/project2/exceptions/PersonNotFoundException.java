package com.project.project2.exceptions;

import lombok.Data;

@Data
public class PersonNotFoundException extends Exception {

    private String message;

    public PersonNotFoundException(String message) {
        this.message = message;
    }
}
