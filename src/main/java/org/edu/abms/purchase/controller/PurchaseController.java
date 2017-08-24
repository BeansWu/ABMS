package org.edu.abms.purchase.controller;

import java.util.List;

import org.edu.abms.purchase.entity.Purchase;
import org.edu.abms.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Purchase> findAll(){		
		return purchaseService.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/findByBudget", method = RequestMethod.GET)
	public List<Purchase> findByBudget(@RequestParam("budgetId") Integer budgetId){		
		return purchaseService.findAll(budgetId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveAll", method = RequestMethod.POST)
	public String saveAll(@RequestBody List<Purchase> list){
		for(int i=0;i<list.size();i++){
			purchaseService.saveOrUpdate(list.get(i));
		}
		return SUCCESS;
	}
	
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public String del(@RequestBody Purchase purchase){
		purchaseService.del(purchase.getId());
		return SUCCESS;
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdate(@RequestBody Purchase purchase) {
		purchaseService.saveOrUpdate(purchase);
		return SUCCESS;
	}
	
	@ResponseBody
	@RequestMapping(value = "/modifyAll", method = RequestMethod.POST)
	public String modifyAll(@RequestBody List<Purchase> list){
		for(int i=0;i<list.size();i++){
			purchaseService.saveOrUpdate(list.get(i));
		}
		return SUCCESS;
	}
	

}
