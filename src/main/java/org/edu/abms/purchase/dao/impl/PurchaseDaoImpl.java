package org.edu.abms.purchase.dao.impl;

import java.util.List;

import org.edu.abms.budget.service.BudgetAppService;
import org.edu.abms.common.dao.BaseDao;
import org.edu.abms.purchase.dao.PurchaseDao;
import org.edu.abms.purchase.entity.Purchase;
import org.edu.abms.purchase.entity.PurchaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/** @Description:TODO 采购明细 dao impl   
 * @author: 吴忠恩
 * @date:   2017年7月10日 下午1:38:24
 */
@Component
@Repository("purchaseDao")
public class PurchaseDaoImpl extends BaseDao implements PurchaseDao{

	@Override
	@Transactional
	public boolean save(Purchase purchase) {
		return super.save(purchase);
		
	}

	@Override
	@Transactional
	public boolean update(Purchase purchase) {
		return super.update(purchase);
		
	}

	@Override
	@Transactional
	public boolean del(Integer id) {
		return super.del("delete from Purchase p where p.id = ?", id);
	}

	@Autowired
	BudgetAppService budgetAppService;
	
	@Override
	@Transactional
	public List<Purchase> findAll(Integer budgetId) {	
		return super.query("from Purchase p where p.budgetApp = ?", budgetAppService.get(budgetId));
	}

	@Override
	@Transactional
	public List<Purchase> findAll() {
		
		return super.query("from Purchase");
	}
	
}
