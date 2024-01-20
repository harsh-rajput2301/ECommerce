package com.example.demo.Entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private String userId;
    private String email;
    private String password;
    private String name;
    private String phoneNo;
}
