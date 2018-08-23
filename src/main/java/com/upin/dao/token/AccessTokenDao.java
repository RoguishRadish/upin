package com.upin.dao.token;

import com.upin.entity.token.AccessToken;

public interface AccessTokenDao {

	/**
	 * 添加
	 */
	void insert(AccessToken accessToken);

	/**
	 * 更新
	 */
	void update(AccessToken accessToken);

	AccessToken getOne();

}
