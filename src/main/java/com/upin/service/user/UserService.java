package com.upin.service.user;

import com.upin.entity.user.WXUser;

public interface UserService {

	/**
	 * 根据id查询user
	 * @param id
	 * @return user
	 */
	WXUser getOneById(String id);
	
	/**
	 * 根据openId查询user
	 * @param user
	 * @return
	 */
	WXUser getOneByOpenId(String openId);
	
	/**
	 * 更新微信用户
	 * @param user
	 */
	void update(WXUser user);

	/**
	 * 新增用户
	 * @param user
	 */
	void insert(WXUser user);
	
}
