package org.edu.abms.user.service.impl;

import org.edu.abms.user.dao.UserDao;
import org.edu.abms.user.entity.User;
import org.edu.abms.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @author: 吴炳生
 * @date: 2017/7/9
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public boolean saveOrUpdate(User user) {
        if (user.getId() == null) {
            return userDao.save(user);
        } else {
            return userDao.update(user);
        }
    }

    @Transactional
    @Override
    public boolean del(Integer userId) {
        return userDao.del(userId);
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Integer userId) {
        return userDao.findById(userId);
    }
}