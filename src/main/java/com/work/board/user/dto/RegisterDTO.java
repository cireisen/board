package com.work.board.user.dto;

import com.work.board.user.domain.User;

public class RegisterDTO {
    private String id;
    private String password;
    private String name;
    private String email;

    public User toEntity()
    {
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        return user;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
