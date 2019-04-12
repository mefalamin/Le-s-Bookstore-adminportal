package com.adminportal.service;


import com.adminportal.domain.User;
import com.adminportal.domain.security.UserRole;

import java.util.Set;

/**
 * created by saikat on 4/11/19
 */
public interface UserService {


    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User save(User user);
}
