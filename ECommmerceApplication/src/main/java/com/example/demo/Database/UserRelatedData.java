package com.example.demo.Database;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
@Data
public class UserRelatedData {

    public void addUser(HashMap<String, Object> user) {
        usersList.add(user);
    }
    public List<HashMap<String, Object>> usersList = Arrays.asList(
            new HashMap<>() {{
                put("userId", "1");
                put("username", "john_doe");
                put("name", "Jane Doe");
                put("password", "password123");
                put("email", "john@example.com");
                put("phoneNumber", "1234567890");
            }},

            new HashMap<>() {{
                put("userId", "2");
                put("username", "jane_smith");
                put("name", "Jane Smith");
                put("password", "securePass");
                put("email", "jane@example.com");
                put("phoneNumber", "9876543210");
            }},

            new HashMap<>() {{
                put("userId", "3");
                put("username", "bob_miller");
                put("name", "bob ");
                put("password", "pass123");
                put("email", "bob@example.com");
                put("phoneNumber", "5551234567");
            }}

    );
}
