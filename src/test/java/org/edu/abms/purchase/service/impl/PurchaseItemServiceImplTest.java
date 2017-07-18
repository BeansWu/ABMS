package org.edu.abms.purchase.service.impl;

import org.edu.abms.purchase.entity.PurchaseItem;
import org.edu.abms.purchase.service.PurchaseItemService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

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
		PurchaseItem purchaseItem =new PurchaseItem("A03", "土地");
		System.out.println(purchaseItem.getId()==null?"空":"非空");
		purchaseItemService.saveOrUpdate(purchaseItem);
	}

	@Test
    public void modifyPurchaseItemAmountLimit(){
	    BigDecimal bigDecimal = new BigDecimal("120.00");
	    Assert.assertTrue(purchaseItemService.modifyPurchaseItemAmountLimit("A03",bigDecimal));
    }
}
