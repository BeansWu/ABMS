package org.edu.abms.budget.service.impl;

import java.util.List;

import org.edu.abms.budget.dao.BudgetAppDao;
import org.edu.abms.budget.entity.BudgetApp;
import org.edu.abms.budget.service.BudgetAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 预算申请 service impl
 * @author: 吴炳生
 * @date: 2017/7/8
 */
@Service("budgetAppService")
public class BudgetAppServiceImpl implements BudgetAppService{
    @Autowired
    private BudgetAppDao budgetAppDao;

    @Transactional
    @Override
    public boolean saveOrUpdate(BudgetApp budgetApp) {
        if (budgetApp.getId() == null) {
            return budgetAppDao.save(budgetApp);
        } else {
            return budgetAppDao.update(budgetApp);
        }
    }

    @Transactional
    @Override
    public boolean del(Integer budgetAppId) {
        return budgetAppDao.del(budgetAppId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BudgetApp> findAll(Integer userId) {
        return budgetAppDao.findAll(userId);
    }

    @Transactional
	@Override
	public BudgetApp get(Integer budgetAppId) {
		return budgetAppDao.get(budgetAppId);
	}

    @Transactional
	@Override
	public BudgetApp findByNum(String number) {
		return budgetAppDao.findByNum(number);
	}
}