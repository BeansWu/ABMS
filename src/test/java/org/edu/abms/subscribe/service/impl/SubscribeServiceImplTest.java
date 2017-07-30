package org.edu.abms.subscribe.service.impl;

import org.edu.abms.common.entity.AuditState;
import org.edu.abms.subscribe.entity.Subscribe;
import org.edu.abms.subscribe.service.SubscribeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @author 吴忠恩
 * @date: 2017年7月29日
 */
public class SubscribeServiceImplTest {
	static ClassPathXmlApplicationContext ctx = null;
	static SubscribeService subscribeService = null;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		subscribeService = ctx.getBean(SubscribeService.class);
	}
	
	@After
	public void tearDown() throws Exception {
		ctx.close();
	}
	
	@Test
	public void saveOrUpdate() throws Exception {
		
		//Subscribe subscribe = new Subscribe("外星人电脑", 20, "台", 20000, "2018", true, "anything", AuditState.SUBMITTED);
		//subscribeService.saveOrUpdate(subscribe);
	}
	
}
