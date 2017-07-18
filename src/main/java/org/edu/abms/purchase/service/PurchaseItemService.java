package org.edu.abms.purchase.service;

import java.math.BigDecimal;
import java.util.List;

import org.edu.abms.purchase.entity.PurchaseItem;

/** @Description:采购品目 Service  
 * @author: 吴忠恩
 * @date:   2017年7月11日 下午3:53:35
 */
public interface PurchaseItemService {

	/** 
	 * 添加或修改采购品目
	 * @param:  purchaseItem     
	 * @return: 操作结果     
	 */
	boolean saveOrUpdate(PurchaseItem purchaseItem);
	
	/** 
	 *  查找当前品目的所有子品目
	 * @param:  fatherId   
	 * @return: 子品目集合     
	 */
	List<PurchaseItem> findAll(Integer fatherId);

	/**
	 * 资产管理部门修改全校同品目编码下自行采购品目的总预算金额
	 * @param code
	 * @param newAmountLimit
	 */
	boolean modifyPurchaseItemAmountLimit(String code, BigDecimal newAmountLimit);
}
