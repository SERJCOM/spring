package com.serj_comp.database;

import org.springframework.data.repository.CrudRepository;

// @Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String name);

    User findById(long id);

}