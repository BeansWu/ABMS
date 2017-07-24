package org.edu.abms.purchase.service;

import java.util.List;

import org.edu.abms.purchase.entity.Purchase;


/** 
 * @Description:  采购项目明细 Service
 * @author: 吴忠恩
 * @date:   2017年7月11日 
 */
public interface PurchaseService {
	
	/** 
	 *  添加或修改采购项目明细
	 * @param: purchase   
	 * @return: 操作结果     
	 */
	boolean saveOrUpdate(Purchase purchase);
	
	/** 
	 *  删除采购项目明细
	 * @param:  purchaseID  
	 * @return: 操作结果     
	 */
	boolean del(Integer purchaseID);
	
	/**
	 * 查找所有采购项目明细（根据预算项目号）
	 * @param budgetAppNumber
	 * @return 操作结果
	 */
	List<Purchase> findAll(Integer budgetId);
	
	/**
	 * 查找所有采购项目明细
	 * @return 操作结果
	 */
	List<Purchase> findAll();
	
}
