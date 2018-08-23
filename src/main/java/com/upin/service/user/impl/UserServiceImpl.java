package com.upin.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upin.dao.user.UserDao;
import com.upin.entity.user.WXUser;
import com.upin.service.user.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	public WXUser getOneById(String id) {
		WXUser auser = userDao.getOneById(id);
		return auser;
	}
	
	@Override
	public WXUser getOneByOpenId(String openId) {
		WXUser auser = userDao.getOneByOpenId(openId);
		return auser;
	}

	@Override
	public void update(WXUser user) {
		userDao.update(user);
	}

	@Override
	public void insert(WXUser user) {
		userDao.insert(user);
	}
}
