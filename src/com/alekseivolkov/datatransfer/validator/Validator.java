package com.alekseivolkov.datatransfer.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
