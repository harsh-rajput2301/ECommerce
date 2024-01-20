package com.example.demo.Manager.Impl;

import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.User;
import com.example.demo.Exception.*;
import com.example.demo.Manager.UserManager;
import com.example.demo.Request.CreateUserRequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Slf4j
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDao userDao;
    @Override
    public User getUserData(String userId) {
        try {
            log.info("Get user not triggered for the id= {}", userId);
            User userDetails = userDao.getUser(userId);
            return userDetails;
        } catch (UserNotFoundException e) {
            String errorMsg = String.format("user not found for userId: %s ", userId);
            log.warn("{} Exception: {}", errorMsg, e.getMessage());
            throw new ResourceNotFoundException(errorMsg);
        } catch (UserDAOException e) {
            throw new InternalServiceException(e.getMessage());
        }
    }

    @Override
    public String createUser(CreateUserRequestBody userData) {
        try {
            User user = User.builder().userId(UUID.randomUUID().toString()).email(userData.getEmail()).password(userData.getPassword()).name(userData.getName()).phoneNo(userData.getPhoneNo()).build();
            log.info("Add user: ", user.getUserId());
            userDao.createUser(user);
            return user.getUserId();
        } catch (UserDAOException e) {
            throw new InternalServiceException(e.getMessage());
        }
    }
}
