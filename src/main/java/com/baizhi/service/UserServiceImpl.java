package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        userDao.register(user);
    }

    @Override
    public void login(User user) {
        User a=null;
        a=userDao.login(user.getUsername());
        if(a==null)throw new RuntimeException("该用户不存在或错误");
        if(!a.getPassword().equals(user.getPassword()))throw new RuntimeException("密码错误");
    }
}
