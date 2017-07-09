package org.edu.abms.budget.dao.impl;

import org.edu.abms.budget.dao.BudgetAppDao;
import org.edu.abms.budget.entity.BudgetApp;
import org.edu.abms.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 预算申请 dao impl
 * @author: 吴炳生
 * @date: 2017/7/8
 */
@Repository("budgetAppDao")
public class BudgetAppDaoImpl extends BaseDao implements BudgetAppDao{
    @Override
    public boolean save(BudgetApp budgetApp) {
        return super.save(budgetApp);
    }

    @Override
    public boolean update(BudgetApp budgetApp) {
        return super.update(budgetApp);
    }

    @Override
    public boolean del(Integer BudgetAppId) {
        return super.del("delete from BudgetApp ba where ba.id = ?", BudgetAppId);
    }

    @Override
    public List<BudgetApp> findAll(Integer userId) {
        return query("from BudgetApp ba where ba.user.id = ?", userId);
    }
}