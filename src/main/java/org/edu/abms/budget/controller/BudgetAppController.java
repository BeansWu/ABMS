package org.edu.abms.budget.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.edu.abms.budget.entity.BudgetApp;
import org.edu.abms.budget.service.BudgetAppService;
import org.edu.abms.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/budget")
public class BudgetAppController {
	
	private static String SUCCESS = "{\"result\":\"success\"}";
	private static String FAILURE = "{\"result\":\"failure\"}";
	
	@Autowired
	private BudgetAppService budgetService;
	
	@Autowired
	private PurchaseService purchaseService;
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public BudgetApp saveOrUpdate(@RequestBody BudgetApp budgetApp) {
		
		budgetService.saveOrUpdate(budgetApp);
		
		return budgetService.findByNum(budgetApp.getNumber());
	}
	
	@ResponseBody
	@RequestMapping(value="/findAll", method = RequestMethod.GET)
	public List<BudgetApp> findAll(@RequestParam("userId") Integer userId){
		return budgetService.findAll(userId);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public Map<String, Object> modify(@RequestParam("budgetId") Integer budgetId){
//		session.setAttribute("budgetApp", budgetService.get(budgetId));
//		session.setAttribute("purchases", purchaseService.findAll(budgetId));
//		System.out.println("------------"+session.getAttribute("budgetApp"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("budgetApp", budgetService.get(budgetId));
		map.put("purchases", purchaseService.findAll(budgetId));
		return map;
	}
	
}
