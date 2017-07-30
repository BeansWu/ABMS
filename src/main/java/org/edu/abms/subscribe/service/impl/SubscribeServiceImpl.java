package org.edu.abms.subscribe.service.impl;

import java.util.List;

import org.edu.abms.subscribe.dao.SubscribeDao;
import org.edu.abms.subscribe.entity.Subscribe;
import org.edu.abms.subscribe.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Service("subscribeService")
public class SubscribeServiceImpl implements SubscribeService{
	
	@Autowired
	private SubscribeDao subscribeDao;

	@Override
	@Transactional
	public boolean saveOrUpdate(Subscribe subscribe) {
		if(subscribe.getId() == null){
			return subscribeDao.save(subscribe);
		}else {
			return subscribeDao.update(subscribe);
		}
	}

	@Override
	@Transactional
	public List<Subscribe> findAll(Integer userId) {
		
		return subscribeDao.findAll(userId);
	}

	@Override
	@Transactional
	public List<Subscribe> findAll() {
		
		return subscribeDao.findAll();
	}

}
