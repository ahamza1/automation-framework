package org.testautomation.app.api.models;

import lombok.Data;

@Data
public class User {
    private final Long id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String phone;
    private final Integer userStatus;
}
