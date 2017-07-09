package org.edu.abms.user.dao.impl;

import org.edu.abms.common.dao.BaseDao;
import org.edu.abms.user.dao.UserDao;
import org.edu.abms.user.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @author: 吴炳生
 * @date: 2017/7/9
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public boolean save(User user) {
        return super.save(user);
    }

    @Override
    public boolean del(Integer userId) {
        return super.del("delete from User u where u.id = ?", userId);
    }

    @Override
    public boolean update(User user) {
        return super.update(user);
    }

    @Override
    public User findById(Integer userId) {
        return super.queryForBean("from User u where u.id = ?", userId);
    }
}