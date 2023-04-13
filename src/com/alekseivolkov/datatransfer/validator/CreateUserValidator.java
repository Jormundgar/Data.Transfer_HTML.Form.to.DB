package com.alekseivolkov.datatransfer.validator;

import com.alekseivolkov.datatransfer.dto.CreateUserDto;
import com.alekseivolkov.datatransfer.entity.Genders;
import com.alekseivolkov.datatransfer.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        var validationResult = new ValidationResult();
        if (!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid.birthday", "Birthday is invalid"));
        }
        if (object.getGender() == null || Genders.find(object.getGender()) == null) {
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
