package org.edu.abms.user.service;

import org.edu.abms.user.entity.User;

/**
 * @Description:
 * @author: 吴炳生
 * @date: 2017/7/9
 */
public interface UserService {
    /**
     * save new user or update user
     * @param user
     * @return 操作结果
     */
    boolean saveOrUpdate(User user);

    /**
     * del user by userId
     * @param userId
     * @return 操作结果
     */
    boolean del(Integer userId);

    /**
     * find user by userId
     * @param userId
     * @return User
     */
    User findById(Integer userId);
}
