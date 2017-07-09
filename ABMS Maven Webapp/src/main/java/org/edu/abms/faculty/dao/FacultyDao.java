package org.edu.abms.faculty.dao;

import org.edu.abms.faculty.entity.Faculty;

/**
 * @Description: 部门 Dao
 * @author: 吴炳生
 * @date: 2017/7/9
 */
public interface FacultyDao {
    /**
     * save new faculty
     * @param faculty
     * @return 操作结果
     */
    boolean save(Faculty faculty);

    /**
     * del faculty by facultyId
     * @param facultyId
     * @return
     */
    boolean del(Integer facultyId);

    /**
     * update faculty
     * @param faculty
     * @return
     */
    boolean update(Faculty faculty);

    /**
     * find by facultyId
     * @param facultyId
     * @return
     */
    Faculty findById(Integer facultyId);
}