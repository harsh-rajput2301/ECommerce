package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Error.CustomException;
import com.example.demo.Exception.InternalServiceException;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Manager.UserManager;
import com.example.demo.Request.CreateUserRequestBody;
import com.example.demo.Response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserManager userManager;

    @GetMapping("/getUser/{userId}")
    public BaseResponse getUser(@PathVariable String userId) {
        if (userId == null) {
            throw new CustomException("error null", HttpStatus.BAD_REQUEST);
        }
        try {
            User user = userManager.getUserData(userId);
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setBody(user);
            baseResponse.setStatus("SUCCESS");
            baseResponse.setResultCode(200);
            return baseResponse;
        } catch (ResourceNotFoundException e) {
            throw new CustomException(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (InternalServiceException e) {
            throw new CustomException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createUser")
    public BaseResponse createUser(@RequestBody CreateUserRequestBody userData) {
        if (userData == null || userData.getEmail() == null || userData.getPassword() == null || userData.getName() == null || userData.getPhoneNo() == null) {
            throw new CustomException("error null", HttpStatus.BAD_REQUEST);
        }
        if (userData.getPassword().length() < 8) {
            throw new CustomException("password is small", HttpStatus.BAD_REQUEST);
        }
        try {
            String userId = userManager.createUser(userData);
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setBody(userId);
            baseResponse.setStatus("SUCCESS");
            baseResponse.setResultCode(200);
            return baseResponse;
        } catch (ResourceNotFoundException e) {
            throw new CustomException(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (InternalServiceException e) {
            throw new CustomException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
