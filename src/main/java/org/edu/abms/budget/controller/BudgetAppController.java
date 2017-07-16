package org.edu.abms.budget.controller;

import org.edu.abms.budget.entity.BudgetApp;
import org.edu.abms.budget.service.BudgetAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/budget")
public class BudgetAppController {
	
	private static String SUCCESS = "{\"result\":\"success\"}";
	private static String FAILURE = "{\"result\":\"failure\"}";
	
	@Autowired
	private BudgetAppService budgetService;
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdate(@RequestBody BudgetApp budgetApp) {
		if(budgetService.saveOrUpdate(budgetApp)){
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
}
