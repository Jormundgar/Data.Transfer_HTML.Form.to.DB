package com.alekseivolkov.datatransfer.validator;


import lombok.Value;

@Value
public final class Error {
    String code;
    String message;

    public static Error of(String code, String message) {
        return new Error(code, message);
    }
}
