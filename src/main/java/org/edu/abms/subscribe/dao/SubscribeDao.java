package org.edu.abms.subscribe.dao;

import java.util.List;

import org.edu.abms.subscribe.entity.Subscribe;

/**
 * @Description:申购 dao
 * @author 吴忠恩
 * @date: 2017年7月28日
 */
public interface SubscribeDao {
	
	/**
	 * 添加申购
	 * @param subscribe
	 * @return 操作结果
	 */
	boolean save(Subscribe subscribe);
	
	/**
	 * 修改申购
	 * @param subscribe
	 * @return 操作结果
	 */
	boolean update(Subscribe subscribe);
	
	/**
	 * 查找所有申购（根据申购人id）
	 * @param subscribeId
	 * @return
	 */
	List<Subscribe> findAll(Integer userId);
	
	/**
	 * 查找所有申购
	 * @return 申购集合
	 */
	List<Subscribe> findAll();

}
