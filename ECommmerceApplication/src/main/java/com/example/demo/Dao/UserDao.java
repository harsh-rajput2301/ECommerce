package com.example.demo.Dao;

import com.example.demo.Database.UserRelatedData;
import com.example.demo.Entity.User;
import com.example.demo.Exception.UserDAOException;
import com.example.demo.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    UserRelatedData userRelatedData;
    public User getUser(String userId) {
        //we are assuming this has been returned by database

        List<HashMap<String, Object>> databaseReturnedUserData = null;
        try {
            databaseReturnedUserData = userRelatedData.getUsersList();
        } catch (Exception e) {
            throw new UserDAOException(e.getMessage());
        }
        HashMap<String, Object> userData = null;
        for (HashMap<String, Object> i: databaseReturnedUserData) {
            if (i.get("userId").equals(userId)) {
                userData = i;
            }
        }
        if (userData == null) {
            throw new UserNotFoundException("Doc not found: " + userId);
        }
        User user = User.builder().userId(userId).email((String) userData.get("email")).name((String) userData.get("name")).phoneNo((String) userData.get("phoneNo")).build();
        return user;
    }

    public void createUser(User user) {
        try {
            HashMap<String, Object> userData = new HashMap<>() {{
                put("userId", user.getUserId());
                put("name", user.getName());
                put("password", user.getPassword());
                put("email", user.getEmail());
                put("phoneNumber", user.getPhoneNo());
            }};
            // successfully added
//            userRelatedData.addUser(userData);
        } catch (Exception e) {
            throw new UserDAOException(e.getMessage());
        }
    }
}
