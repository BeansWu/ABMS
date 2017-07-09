package org.edu.abms.faculty.dao.impl;

import org.edu.abms.common.dao.BaseDao;
import org.edu.abms.faculty.dao.FacultyDao;
import org.edu.abms.faculty.entity.Faculty;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @author: 吴炳生
 * @date: 2017/7/9
 */
@Repository("facultyDap")
public class FacultyDaoImpl extends BaseDao implements FacultyDao{
    @Override
    public boolean save(Faculty faculty) {
        return super.save(faculty);
    }

    @Override
    public boolean del(Integer facultyId) {
        return super.del("delete from Faculty f where f.id = ?", facultyId);
    }

    @Override
    public boolean update(Faculty faculty) {
        return super.update(faculty);
    }

    @Override
    public Faculty findById(Integer facultyId) {
        return super.queryForBean("from Faculty f where f.id = ?", facultyId);
    }
}