package org.edu.abms.common.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: BaseDao
 * @author: 吴炳生
 * @date: 2017/7/8
 */
public class BaseDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 保存新纪录
     * @param object
     * @return
     */
    public Boolean save (Object object) {
        try {
            getSession().save(object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查询记录
     * @param hql
     * @param objects
     * @param <T>
     * @return
     */
    public <T> T queryForBean (String hql, Object ...objects) {
        Query query = getSession().createQuery(hql);
        try{
            for (int i = 0; i < objects.length && objects[i] != null; i++) {
                query.setParameter(i, objects[i]);
            }
            T bean = (T) query.uniqueResult();
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 更新原有记录
     * @param object
     * @return
     */
    public Boolean update (Object object) {
        try {
            getSession().update(object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 更新原有记录
     * @param hql
     * @param objects
     * @return
     */
    public Boolean update (String hql, Object ...objects) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < objects.length && objects[i] != null; i++) {
            query.setParameter(i, objects[i]);
        }
        try {
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除原有记录
     * @param hql
     * @param objects
     * @return
     */
    public Boolean del (String hql, Object ...objects) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < objects.length && objects[i] != null; i++) {
            query.setParameter(i, objects[i]);
        }
        try {
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查询记录集合
     * @param hql
     * @param objects
     * @param <T>
     * @return
     */
    public <T> List<T> query (String hql, Object ...objects) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < objects.length && objects[i] != null; i++) {
            query.setParameter(i, objects[i]);
        }
        List<T> list = query.list();
        return list;
    }
}