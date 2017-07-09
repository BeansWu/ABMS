package org.edu.abms.budget.service;

import org.edu.abms.budget.entity.BudgetApp;

import java.util.List;

/**
 * @Description: 预算申请 Service
 * @author: 吴炳生
 * @date: 2017/7/8
 */
public interface BudgetAppService {
    /**
     * 添加或修改预算申请
     * @param budgetApp
     * @return 操作结果
     */
    boolean saveOrUpdate(BudgetApp budgetApp);

    /**
     * 删除预算申请
     * @param budgetAppId
     * @return 操作结果
     */
    boolean del(Integer budgetAppId);

    /**
     * 查询当前用户的所有预算申请记录
     * @param userId
     * @return 预算申请记录集合
     */
    List<BudgetApp> findAll(Integer userId);
}
