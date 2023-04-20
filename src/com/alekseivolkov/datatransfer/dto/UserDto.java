package com.alekseivolkov.datatransfer.dto;

import com.alekseivolkov.datatransfer.entity.Genders;
import com.alekseivolkov.datatransfer.entity.Roles;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class UserDto {
    Integer id;
    String name;
    LocalDate birthday;
    String email;
    Roles role;
    Genders gender;
}
