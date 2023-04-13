package com.alekseivolkov.datatransfer.service;

import com.alekseivolkov.datatransfer.dao.UserDao;
import com.alekseivolkov.datatransfer.dto.CreateUserDto;
import com.alekseivolkov.datatransfer.exception.ValidationException;
import com.alekseivolkov.datatransfer.mapper.CreateUserMapper;
import com.alekseivolkov.datatransfer.validator.CreateUserValidator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();

    public Integer create(CreateUserDto userDto) {
        // validation
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        // map
        var userEntity = createUserMapper.mapFrom(userDto);
        // userDao.save
        userDao.save(userEntity);
        // return id
        return userEntity.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
