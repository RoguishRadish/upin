package com.upin.dao.user;

import com.upin.entity.user.WXUser;

public interface UserDao {

	/**
	 * 根据id查询user用户信息
	 * @param user
	 * @return
	 */
	WXUser getOneById(String id);
	
	/**
	 * 根据openId查询user用户信息
	 * @param user
	 * @return
	 */
	WXUser getOneByOpenId(String openId);

	/**
	 * 更新user
	 * @param user
	 * @return
	 */
	void update(WXUser user);
	
	/**
	 * 新增用户
	 * @param user
	 */
	void insert(WXUser user);
	
}
