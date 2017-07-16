package org.edu.abms.purchase.dao;

import java.util.List;

import org.edu.abms.purchase.entity.Purchase;
import org.edu.abms.purchase.entity.PurchaseItem;

/** @Description:采购明细 dao   
 * @author: 吴忠恩
 * @date:   2017年7月10日 下午1:31:28
 */
public interface PurchaseDao {
	
	/** 
	 *  添加采购项目明细
	 * @param:  purchase    
	 * @return: 操作结果     
	 */
	boolean save(Purchase purchase);
	
	/** 
	 *  修改采购项目明细
	 * @param:  purchase    
	 * @return: 操作结果     
	 */
	boolean update(Purchase purchase);
	
	/** 
	 *  删除采购项目明细
	 * @param: purchaseId   
	 * @return: 操作结果     
	 */
	boolean del(Integer purchaseId);
	
	/** 
	 *  查找所有采购项目(根据项目号)
	 * @return: 操作结果     
	 */
	List<Purchase> findAll(Integer budgetId);
	
	
}
