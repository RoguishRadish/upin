package com.upin.controller.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upin.entity.token.AccessToken;
import com.upin.service.token.AccessTokenService;

import com.common.config.LoadProperties;
import com.common.wxcategory.WxCategory;

@Controller
@RequestMapping("/token")
public class AccessTokenController {
	
	@Autowired
    AccessTokenService accessTokenService;
	
	/**
	 * 获取token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getToken")
	public void getToken() throws Exception {
		String appId = LoadProperties.APPID;
		AccessToken accessToken = accessTokenService.getOne();
		if(accessToken == null) {
			AccessToken access = new AccessToken();
			access.setId(appId);
			access.setToken(WxCategory.getAccessToken());
			access.setUpdateTime(String.valueOf(System.currentTimeMillis()));
			accessTokenService.insert(access);
		}else {
			if (WxCategory.checkToken(accessToken) == false) {
				String token = WxCategory.getAccessToken();
				accessToken.setToken(token);
				accessToken.setUpdateTime(String.valueOf(System.currentTimeMillis()));
				accessTokenService.update(accessToken);
			}
		}
	}
}
