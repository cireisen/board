package com.work.board.user.repository;

import com.work.board.user.domain.User;

import java.util.List;

public interface UserMapper {

    public List<User> findAll() throws Exception;
    public void save(User user) throws Exception;
    public User findById(String id) throws Exception;
}
