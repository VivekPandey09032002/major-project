package com.vivek.book.store.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;

    private String gender;
}
