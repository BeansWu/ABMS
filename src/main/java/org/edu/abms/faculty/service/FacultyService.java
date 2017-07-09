package org.edu.abms.faculty.service;

import org.edu.abms.faculty.entity.Faculty;

/**
 * @Description: 部门 Service
 * @author: 吴炳生
 * @date: 2017/7/9
 */
public interface FacultyService {
    /**
     * save new faculty or update faculty
     * @param faculty
     * @return 操作结果
     */
    boolean saveOrUpdate(Faculty faculty);

    /**
     * del faculty by facultyId
     * @param facultyId
     * @return 操作结果
     */
    boolean del(Integer facultyId);

    /**
     * find faculty by facultyId
     * @param facultyId
     * @return Faculty or null
     */
    Faculty findById(Integer facultyId);
}
