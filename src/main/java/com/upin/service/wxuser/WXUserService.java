package com.upin.service.wxuser;

import com.upin.entity.wxuser.WXUser;

public interface WXUserService {

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
	int update(WXUser wxUser);

	/**
	 * 新增用户
	 * @param user
	 */
	int insert(WXUser wxUser);
	
}
