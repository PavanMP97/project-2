package com.project.project2.exceptions;

import lombok.Data;

@Data
public class VehicleNotFoundException extends Exception {
    private String message;

    public VehicleNotFoundException(String message) {
        this.message = message;
    }
}
