package com.example.front_buhg.repository;

import com.example.front_buhg.model.UserModel;
import org.springframework.data.repository.CrudRepository;


public interface JpaUserRepository extends CrudRepository<UserModel, Long> {
    UserModel findByUsername(String username);
    boolean existsByUsername(String username);

}
