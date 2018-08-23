package com.upin.service.token;

import com.upin.entity.token.AccessToken;

public interface AccessTokenService {

	AccessToken getOne();

	void update(AccessToken accessToken);

	void insert(AccessToken access);
	
	AccessToken getNewToken() throws Exception;
}
