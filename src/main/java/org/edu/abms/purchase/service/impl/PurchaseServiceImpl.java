package org.edu.abms.purchase.service.impl;

import java.util.List;

import org.edu.abms.purchase.dao.PurchaseDao;
import org.edu.abms.purchase.entity.Purchase;
import org.edu.abms.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 
 * @Description:  采购项目明细 Service impl
 * @author: 吴忠恩
 * @date:   2017年7月11日 
 */
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	private PurchaseDao purchaseDao;
	
	@Override
	@Transactional
	public boolean saveOrUpdate(Purchase purchase) {
		if(purchase.getId() == null) {
			return purchaseDao.save(purchase);
		} else {
			return purchaseDao.update(purchase);
		}
	}

	@Override
	@Transactional
	public boolean del(Integer purchaseId) {
		return purchaseDao.del(purchaseId);
	}

	@Override
	@Transactional
	public List<Purchase> findAll(Integer budgetId) {
		return purchaseDao.findAll(budgetId);
	}
	
}
