package org.edu.abms.purchase.service.impl;

import org.edu.abms.purchase.entity.PurchaseItem;
import org.edu.abms.purchase.service.PurchaseItemService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * @Description:   
 * @author: 吴忠恩
 * @date:   2017年7月11日 
 */
public class PurchaseItemServiceImplTest {
	static ClassPathXmlApplicationContext ctx = null;
	static PurchaseItemService purchaseItemService = null;
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		purchaseItemService = ctx.getBean(PurchaseItemService.class);
	}
	
	@After
	public void tearDown() throws Exception {
		ctx.close();
	}
	
	
	@Test
	public void saveOrUpdate() throws Exception {
		PurchaseItem purchaseItem =new PurchaseItem("A01", "土地");
		System.out.println(purchaseItem.getId()==null?"空":"非空");
		purchaseItemService.saveOrUpdate(purchaseItem);
	}
}
