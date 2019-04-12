package com.adminportal.service.impl;

import com.adminportal.domain.User;
import com.adminportal.domain.security.UserRole;
import com.adminportal.repository.RoleRepository;
import com.adminportal.repository.UserRepository;
import com.adminportal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * created by saikat on 4/11/19
 */

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);


    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }



    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
         User localUser = userRepository.findByUsername(user.getUsername());

         if(localUser !=null){
             LOG.info("user {} already exists.Nothing will be done.",user.getUsername());

         }else
         {
             for (UserRole ur : userRoles
                  ) {
                 roleRepository.save(ur.getRole());
                 
             }
            user.getUserRoles().addAll(userRoles);
             localUser = userRepository.save(user);
         }
         return localUser;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
