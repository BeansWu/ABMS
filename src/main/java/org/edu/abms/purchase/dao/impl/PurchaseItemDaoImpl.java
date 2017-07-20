package org.edu.abms.purchase.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import org.edu.abms.common.dao.BaseDao;
import org.edu.abms.purchase.dao.PurchaseItemDao;
import org.edu.abms.purchase.entity.PurchaseItem;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/** @Description:采购品目dao impl  
 * @author: 吴忠恩
 * @date:   2017年7月10日 下午1:48:15
 */
@Component
@Repository("purchaseItemDao")
public class PurchaseItemDaoImpl extends BaseDao implements PurchaseItemDao{

	@Override
	@Transactional
	public boolean modifyPurchaseItemAmountLimit(String code, BigDecimal newAmountLimit) {
		PurchaseItem purchaseItem = findByCode(code);
		purchaseItem.setAmountLimit(newAmountLimit);
		return super.save(purchaseItem);
	}

	@Override
	@Transactional
	public boolean save(PurchaseItem purchaseItem) {
		return super.save(purchaseItem);		
	}
	
	@Override
	@Transactional
	public boolean update(PurchaseItem purchaseItem) {
		return super.update(purchaseItem);
	}

	@Override
	@Transactional
	public PurchaseItem findByCode(String code) {
		String hql = "from PurchaseItem as pi where pi.code = ?";
		PurchaseItem purchaseJoural = queryForBean(hql,code);
		return purchaseJoural;
	}

	@Override
	@Transactional
	public List<PurchaseItem> findAll() {
		String hql = "from PurchaseItem";
		List<PurchaseItem> list = super.query(hql);
		return list;
	}




	
}
