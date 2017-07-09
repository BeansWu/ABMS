package org.edu.abms.budget.dao;

import org.edu.abms.budget.entity.BudgetApp;

import java.util.List;

/**
 * @Description: 预算申请 Dao
 * @author: 吴炳生
 * @date: 2017/7/8
 */
public interface BudgetAppDao {
    /**
     * 保存新的预算申请
     * @param budgetApp
     * @return 操作结果
     */
    boolean save(BudgetApp budgetApp);

    /**
     * 修改原有的预算申请
     * @param budgetApp
     * @return 操作结果
     */
    boolean update(BudgetApp budgetApp);

    /**
     * 删除预算申请
     * @param BudgetAppId
     * @return 操作结果
     */
    boolean del(Integer BudgetAppId);

    /**
     * 查询当前用户的所有预算申请记录
     * @param userId
     * @return 预算申请记录集合
     */
    List<BudgetApp> findAll(Integer userId);
}
