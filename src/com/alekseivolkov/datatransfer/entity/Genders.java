package com.alekseivolkov.datatransfer.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Genders {
    MALE,
    FEMALE;

    public static Optional<Genders> find(String gender) {
        return Arrays.stream(values())
                .filter(it -> it.name().equals(gender))
                .findFirst();
    }
}
