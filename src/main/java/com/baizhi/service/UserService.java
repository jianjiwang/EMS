package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    public void register(User user);

    public void  login(User user);
}
