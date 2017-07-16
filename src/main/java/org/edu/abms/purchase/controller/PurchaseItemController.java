package org.edu.abms.purchase.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.edu.abms.purchase.entity.PurchaseItem;
import org.edu.abms.purchase.service.PurchaseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/purchaseItem")
public class PurchaseItemController {
	
	private static String SUCCESS = "{\"result\":\"success\"}";
	private static String FAILURE = "{\"result\":\"failure\"}";
	
	@Autowired
	private PurchaseItemService purchaseService;
	
	@ResponseBody
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public Map<String,Object> findAll(){		
		Map<String,Object> map = new HashMap<String,Object>();
		List<PurchaseItem> purchaseItems =purchaseService.findAll(1);
		map.put("purchaseItems", purchaseItems);
		return map;
	}
	

}
