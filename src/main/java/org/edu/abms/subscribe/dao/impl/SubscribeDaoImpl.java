package org.edu.abms.subscribe.dao.impl;

import java.util.List;

import org.edu.abms.common.dao.BaseDao;
import org.edu.abms.subscribe.dao.SubscribeDao;
import org.edu.abms.subscribe.entity.Subscribe;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:申购 dao impl
 * @author 吴忠恩
 * @date: 2017年7月28日
 */
@Component
@Repository("subscribeDao")
public class SubscribeDaoImpl extends BaseDao implements SubscribeDao{

	@Override
	@Transactional
	public boolean save(Subscribe subscribe) {
		
		return super.save(subscribe);
	}

	@Override
	@Transactional
	public List<Subscribe> findAll(Integer userId) {
		String hql = "from Subscribe as s where s.user.id = ?";
		List<Subscribe> list = super.query(hql, userId);
		return list;
	}

	@Override
	@Transactional
	public List<Subscribe> findAll() {
		String hql = "from Subscribe";
		List<Subscribe> list = super.query(hql);
		return list;
	}

	@Override
	@Transactional
	public boolean update(Subscribe subscribe) {
		
		return super.update(subscribe);
	}

}
