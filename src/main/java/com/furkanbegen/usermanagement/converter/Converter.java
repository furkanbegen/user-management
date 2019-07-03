package com.furkanbegen.usermanagement.converter;


public interface Converter<E, K> {

    E convertToModel(K k);

    K convertToDto(E e);
}
