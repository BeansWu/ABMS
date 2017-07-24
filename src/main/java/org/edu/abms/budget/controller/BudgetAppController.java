package org.edu.abms.budget.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.edu.abms.budget.entity.BudgetApp;
import org.edu.abms.budget.service.BudgetAppService;
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
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdate(@RequestBody BudgetApp budgetApp) {
		if(budgetService.saveOrUpdate(budgetApp)){
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/findAll", method = RequestMethod.GET)
	public List<BudgetApp> findAll(@RequestParam("userId") Integer userId){
		//System.out.println("接收到"+userId);
		return budgetService.findAll(userId);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modify(@RequestBody BudgetApp budgetApp, HttpSession session ){
		session.setAttribute("budgetApp", budgetApp);
		return SUCCESS;
	}
}
