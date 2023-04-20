package com.alekseivolkov.datatransfer.mapper;

import com.alekseivolkov.datatransfer.dto.UserDto;
import com.alekseivolkov.datatransfer.entity.Users;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserMapper implements Mapper<Users, UserDto> {

    private static final UserMapper INSTANCE = new UserMapper();

    @Override
    public UserDto mapFrom(Users object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .birthday(object.getBirthday())
                .email(object.getEmail())
                .role(object.getRole())
                .gender(object.getGender())
                .build();
    }
    public static UserMapper getInstance() {
        return INSTANCE;
    }
}
