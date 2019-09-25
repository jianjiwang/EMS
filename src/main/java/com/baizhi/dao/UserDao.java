package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao {
    public void register(User user);

    public User login(String username);
}
