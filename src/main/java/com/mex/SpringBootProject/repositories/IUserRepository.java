package com.mex.SpringBootProject.repositories;

import com.mex.SpringBootProject.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
}
