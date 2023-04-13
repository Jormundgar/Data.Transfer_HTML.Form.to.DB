package com.alekseivolkov.datatransfer.mapper;

import com.alekseivolkov.datatransfer.dto.CreateUserDto;
import com.alekseivolkov.datatransfer.entity.Genders;
import com.alekseivolkov.datatransfer.entity.Roles;
import com.alekseivolkov.datatransfer.entity.Users;
import com.alekseivolkov.datatransfer.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, Users> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public Users mapFrom(CreateUserDto object) {
        return Users.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .role(Roles.valueOf(object.getRole()))
                .gender(Genders.valueOf(object.getGender()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
