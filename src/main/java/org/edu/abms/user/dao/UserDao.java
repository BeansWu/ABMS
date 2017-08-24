package org.edu.abms.user.dao;

import org.edu.abms.user.entity.User;

/**
 * @Description: 用户 Dao
 * @author: 吴炳生
 * @date: 2017/7/9
 */
public interface UserDao {
    /**
     * save user
     * @param user
     * @return 操作结果
     */
    boolean save(User user);

    /**
     * del User by userId
     * @param userId
     * @return 操作结果
     */
    boolean del(Integer userId);

    /**
     * update user
     * @param user
     * @return 操作结果
     */
    boolean update(User user);

    /**
     * find by userId
     * @param userId
     * @return 操作结果
     */
    User findById(Integer userId);
    
    /**
     * 通过账号查找
     * @param account
     * @return 用户实体
     */
    User findByAccount(String account);
}
