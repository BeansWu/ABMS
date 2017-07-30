package org.edu.abms.purchase.controller;

import java.math.BigDecimal;
import java.util.List;

import org.edu.abms.purchase.entity.PurchaseItem;
import org.edu.abms.purchase.service.PurchaseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/purchaseItem")
public class PurchaseItemController {

    private static String SUCCESS = "{\"result\":\"success\"}";
    private static String FAILURE = "{\"result\":\"failure\"}";

    @Autowired
    private PurchaseItemService purchaseItemService;

    @ResponseBody
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<PurchaseItem> findAll() {
        return purchaseItemService.findAll();
    }
    
    @ResponseBody
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public PurchaseItem findById(@RequestParam Integer id){

    	return purchaseItemService.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/modifyPurchaseItemAmountLimit")
    public String modifyPurchaseItemAmountLimit(String code, String newAmountLimit) {
        BigDecimal bigDecimal = new BigDecimal(newAmountLimit);
        if (purchaseItemService.modifyPurchaseItemAmountLimit(code, bigDecimal)) {
            return SUCCESS;
        } else {
            return FAILURE;
        }
    }


}
