package org.edu.abms.subscribe.controller;

import java.util.List;

import org.edu.abms.subscribe.entity.Subscribe;
import org.edu.abms.subscribe.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/subscribe")
public class SubscribeController {
	
	private static String SUCCESS = "{\"result\":\"success\"}";
	private static String FAILURE = "{\"result\":\"failure\"}";
	
	@Autowired
	private SubscribeService subscribeService;
	
	@ResponseBody
	@RequestMapping(value="/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdate(@RequestBody Subscribe subscribe){
		subscribeService.saveOrUpdate(subscribe);
		return SUCCESS;
	}
	
	@ResponseBody
	@RequestMapping(value="/findAll", method = RequestMethod.GET)
	public List<Subscribe> findAll(@RequestParam Integer userId){
		return subscribeService.findAll(userId);
	}
	
	@ResponseBody
	@RequestMapping(value="/modifyAll", method = RequestMethod.POST)
	public String modifyAll(@RequestBody List<Subscribe> list){
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getAuditState());
			subscribeService.saveOrUpdate(list.get(i));
		}
		return SUCCESS;
	}
}
