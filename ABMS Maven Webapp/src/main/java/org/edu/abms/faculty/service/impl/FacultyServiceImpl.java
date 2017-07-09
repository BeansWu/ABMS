package org.edu.abms.faculty.service.impl;

import org.edu.abms.faculty.dao.FacultyDao;
import org.edu.abms.faculty.entity.Faculty;
import org.edu.abms.faculty.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 部门 Service impl
 * @author: 吴炳生
 * @date: 2017/7/9
 */
@Service("facultyService")
public class FacultyServiceImpl implements FacultyService{
    @Autowired
    private FacultyDao facultyDao;

    @Transactional
    @Override
    public boolean saveOrUpdate(Faculty faculty) {
        if (faculty.getId() == null) {
            return facultyDao.save(faculty);
        } else {
            return facultyDao.update(faculty);
        }
    }

    @Transactional
    @Override
    public boolean del(Integer facultyId) {
        return facultyDao.del(facultyId);
    }

    @Transactional(readOnly = true)
    @Override
    public Faculty findById(Integer facultyId) {
        return facultyDao.findById(facultyId);
    }
}