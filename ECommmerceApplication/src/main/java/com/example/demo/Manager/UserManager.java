package com.example.demo.Manager;

import com.example.demo.Entity.User;
import com.example.demo.Request.CreateUserRequestBody;

public interface UserManager {
    public User getUserData(String userId);
    public String createUser(CreateUserRequestBody userData);
}
