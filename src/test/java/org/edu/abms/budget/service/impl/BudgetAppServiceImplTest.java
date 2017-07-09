package org.edu.abms.budget.service.impl;

import org.edu.abms.budget.service.BudgetAppService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: BudgetAppServiceImplTest
 * @author: 吴炳生
 * @date: 2017/7/9
 */
public class BudgetAppServiceImplTest {

    static ClassPathXmlApplicationContext ctx = null;
    static BudgetAppService budgetAppService = null;

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        budgetAppService = ctx.getBean(BudgetAppService.class);
    }

    @After
    public void tearDown() throws Exception {
        ctx.close();
    }

    @Test
    public void saveOrUpdate() throws Exception {

    }

    @Test
    public void del() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }

}