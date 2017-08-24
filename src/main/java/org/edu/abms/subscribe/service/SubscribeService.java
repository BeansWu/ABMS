package org.edu.abms.subscribe.service;

import java.util.List;

import org.edu.abms.subscribe.entity.Subscribe;

/**
 * @Description:申购 Service
 * @author 吴忠恩
 * @date: 2017年7月28日
 */
public interface SubscribeService {
	
	/**
	 * 添加或修改申购
	 * @param subscribe
	 * @return 操作结果
	 */
	boolean saveOrUpdate(Subscribe subscribe);
	
	/**
	 * 查找所有申购（根据申购人id）
	 * @param userId
	 * @return 申购集合
	 */
	List<Subscribe> findAll(Integer userId);
	
	/**
	 * 查找所有申购
	 * @return 申购集合
	 */
	List<Subscribe> findAll();
}
