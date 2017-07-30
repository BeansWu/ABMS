package org.edu.abms.purchase.dao;

import java.math.BigDecimal;
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
	 * 根据ID查找
	 * @param id
	 * @return
	 */
	PurchaseItem findById(Integer id);
	
	/** 
	 *  查找所有品目信息
	 * @return: 操作结果
	 */
	List<PurchaseItem> findAll();	

	/**
	 * 资产管理部门修改全校同品目编码下自行采购项目的预算限制
	 * @param code
	 * @param newAmountLimit
	 * @return: 修改是否成功：成功（true），失败（false）
	 */
	boolean modifyPurchaseItemAmountLimit(String code, BigDecimal newAmountLimit);
}
