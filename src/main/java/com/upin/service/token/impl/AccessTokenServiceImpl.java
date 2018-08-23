package com.upin.service.token.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.config.LoadProperties;
import com.common.wxcategory.WxCategory;
import com.upin.dao.token.AccessTokenDao;
import com.upin.entity.token.AccessToken;
import com.upin.service.token.AccessTokenService;

@Service("accessTokenService")
@Transactional
public class AccessTokenServiceImpl implements AccessTokenService {
	@Autowired
	AccessTokenDao accessTokenDao;

	@Override
	public AccessToken getOne() {
		AccessToken accessToken = accessTokenDao.getOne();
		return accessToken;
	}

	@Override
	public void update(AccessToken accessToken) {
		accessTokenDao.update(accessToken);
	}

	@Override
	public void insert(AccessToken accessToken) {
		accessTokenDao.insert(accessToken);
	}

	@Override
	public AccessToken getNewToken() throws Exception{
		String appId = LoadProperties.APPID;
		AccessToken accessToken = accessTokenDao.getOne();
		if(accessToken == null) {
			accessToken = new AccessToken();
			accessToken.setId(appId);
			accessToken.setToken(WxCategory.getAccessToken());
			accessToken.setUpdateTime(String.valueOf(System.currentTimeMillis()));
			accessTokenDao.insert(accessToken);
		}else {
			if (WxCategory.checkToken(accessToken) == false) {
				String token = WxCategory.getAccessToken();
				accessToken.setToken(token);
				accessToken.setUpdateTime(String.valueOf(System.currentTimeMillis()));
				accessTokenDao.update(accessToken);
			}
		}
		return accessToken;
	}
	
}