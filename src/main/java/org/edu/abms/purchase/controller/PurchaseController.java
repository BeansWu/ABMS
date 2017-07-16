package org.edu.abms.purchase.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.edu.abms.budget.entity.BudgetApp;
import org.edu.abms.purchase.entity.Purchase;
import org.edu.abms.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/purchase")
public class PurchaseController {
	
	private static String SUCCESS = "{\"result\":\"success\"}";
	private static String FAILURE = "{\"result\":\"failure\"}";
	
	@Autowired
	private PurchaseService purchaseService;
	
	@ResponseBody
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public Map<String,Object> findAll(){		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Purchase> purchases = purchaseService.findAll(1);
		map.put("purchases", purchases);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveAll", method = RequestMethod.POST)
	public String saveAll(@RequestBody List<Purchase> list){
		for(int i=0;i<list.size();i++){
			purchaseService.saveOrUpdate(list.get(i));
		}
		return SUCCESS;
	}
}
