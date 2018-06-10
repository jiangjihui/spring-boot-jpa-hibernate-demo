package com.services;

import com.models.Dog;

public interface IDogService {

    Dog create(Dog dog) throws Exception;

    Dog findById(Integer id) throws Exception;

    Dog update(Dog dog) throws Exception;

    Boolean delById(Integer id) throws Exception;
}
