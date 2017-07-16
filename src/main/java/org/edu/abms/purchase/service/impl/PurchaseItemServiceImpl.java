package org.edu.abms.purchase.service.impl;

import java.util.List;

import org.edu.abms.purchase.dao.PurchaseItemDao;
import org.edu.abms.purchase.entity.PurchaseItem;
import org.edu.abms.purchase.service.PurchaseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 
 * @Description:采购项目 Service Impl 
 * @author: 吴忠恩
 * @date:   2017年7月11日 
 */
@Service("purchaseItemService")
public class PurchaseItemServiceImpl implements PurchaseItemService{
	
	@Autowired
	private PurchaseItemDao purchaseItemDao;

	@Override
	@Transactional
	public boolean saveOrUpdate(PurchaseItem purchaseItem) {
		if (purchaseItem.getId() == null) {
			return purchaseItemDao.save(purchaseItem);
		} else {
			return purchaseItemDao.update(purchaseItem);
		}
	}


	@Override
	public List<PurchaseItem> findAll(Integer fatherId) {
		return purchaseItemDao.findAll();
	}
	
}
