package com.upin.service.wxuser.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upin.dao.wxuser.WXUserDao;
import com.upin.entity.wxuser.WXUser;
import com.upin.service.wxuser.WXUserService;

@Service("wxUserService")
@Transactional
public class WXUserServiceImpl implements WXUserService {
	@Autowired
	WXUserDao wxUserDao;

	@Override
	public WXUser getOneById(String id) {
		WXUser wxUser = wxUserDao.getOneById(id);
		return wxUser;
	}
	
	@Override
	public WXUser getOneByOpenId(String openId) {
		WXUser wxUser = wxUserDao.getOneByOpenId(openId);
		return wxUser;
	}

	@Override
	public int update(WXUser wxUser) {
		int count = wxUserDao.update(wxUser);
		return count;
	}

	@Override
	public int insert(WXUser user) {
		int count = wxUserDao.insert(user);
		return count;
	}
}
