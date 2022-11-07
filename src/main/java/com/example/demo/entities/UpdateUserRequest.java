package com.example.demo.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateUserRequest {
    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String homeAddress;
}
