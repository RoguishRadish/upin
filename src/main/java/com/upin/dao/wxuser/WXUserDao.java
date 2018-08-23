package com.upin.dao.wxuser;

import com.upin.entity.wxuser.WXUser;

public interface WXUserDao {

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
	int update(WXUser user);
	
	/**
	 * 新增用户
	 * @param user
	 */
	int insert(WXUser user);
	
}
