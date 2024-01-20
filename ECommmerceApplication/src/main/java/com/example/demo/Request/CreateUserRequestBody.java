package com.example.demo.Request;

import lombok.Data;

@Data
public class CreateUserRequestBody {
    private String userName;
    private String email;
    private String password;
    private String name;
    private String phoneNo;
}
