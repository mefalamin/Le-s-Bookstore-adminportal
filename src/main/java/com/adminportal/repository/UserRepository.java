package com.adminportal.repository;

import com.adminportal.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * created by saikat on 4/13/19
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
