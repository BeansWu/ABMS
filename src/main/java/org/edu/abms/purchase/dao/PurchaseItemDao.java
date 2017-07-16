package org.edu.abms.purchase.dao;

import java.util.List;

import org.edu.abms.purchase.entity.PurchaseItem;

/** @Description:TODO 采购品目 dao  
 * @author: 吴忠恩
 * @date:   2017年7月10日 下午1:36:23
 */
public interface PurchaseItemDao {
	
	/** 
	 *  添加采购项目
	 * @param: purchaseItem 
	 * @return: 操作结果      
	 */
	boolean save(PurchaseItem purchaseItem);
	
	/** 
	 *  修改采购项目
	 * @param:  purchaseItem    
	 * @return: 操作结果      
	 */
	boolean update(PurchaseItem purchaseItem);

	/** 
	 *  根据品目编码查找
	 * @param:  code    
	 * @return: 操作结果     
	 */
	PurchaseItem findByCode(String code);
	
	/** 
	 *  查找所有品目信息   
	 * @return: 操作结果     
	 */
	List<PurchaseItem> findAll();
}
