package com.alekseivolkov.datatransfer.mapper;

public interface Mapper<F, T> {
    T mapFrom(F object);

}
