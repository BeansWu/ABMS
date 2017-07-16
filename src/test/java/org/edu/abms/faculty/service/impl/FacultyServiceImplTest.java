package org.edu.abms.faculty.service.impl;

import org.edu.abms.faculty.entity.Faculty;
import org.edu.abms.faculty.service.FacultyService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @author: 吴炳生
 * @date: 2017/7/9
 */
public class FacultyServiceImplTest {

    static ClassPathXmlApplicationContext ctx = null;
    static FacultyService facultyService = null;
    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        facultyService = ctx.getBean(FacultyService.class);
    }

    @After
    public void tearDown() throws Exception {
        ctx.close();
    }

    @Test
    public void saveOrUpdate() throws Exception {
        Faculty faculty = new Faculty("01", "光电与信息工程学院", "光电学院", "GDYXXGCXY");
        System.out.println(faculty.getId()==null?"空":"非空");
        facultyService.saveOrUpdate(faculty);
    }

    @Test
    public void del() throws Exception {

    }

    @Test
    public void findById() throws Exception {
        System.out.println(facultyService.findById(1));
    }

}