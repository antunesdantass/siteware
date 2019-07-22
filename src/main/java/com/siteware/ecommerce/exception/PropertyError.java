package com.siteware.ecommerce.exception;

import org.springframework.http.HttpStatus;

public class PropertyError {

    private String property;

    public PropertyError(String property) {
        this.property = property;
    }

    public String missingProperty() {
        return new StringBuilder()
                .append("The property ").append(property)
                .append(" cannot be missing.").toString();
    }

    public String invalidValue() {
        return new StringBuilder()
                .append("The value for the property ").append(property)
                .append(" is invalid.").toString();
    }
}
