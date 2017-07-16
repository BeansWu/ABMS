package org.edu.abms.purchase.service.impl;

import org.edu.abms.budget.dao.BudgetAppDao;
import org.edu.abms.purchase.entity.Purchase;
import org.edu.abms.purchase.service.PurchaseService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * @Description:  
 * @author: 吴忠恩
 * @date:   2017年7月11日 
 */
public class PurchaseServiceImplTest {
	static ClassPathXmlApplicationContext ctx = null;
	static PurchaseService purchaseService = null;
	@Autowired
	BudgetAppDao budgetAppDao;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		purchaseService = ctx.getBean(PurchaseService.class);
	}
	
	@After
	public void tearDown() throws Exception {
		ctx.close();
	}
	
	@Test
	public void saveOrUpdate() throws Exception {
		//Purchase purchase = new Purchase(budgetAppDao.get(1), purchaseItem, 20, "只", 20000, true, false, false, false);
	}
}
