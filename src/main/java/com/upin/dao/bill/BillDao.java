package com.upin.dao.bill;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.upin.entity.bill.Bill;

public interface BillDao {

	void insert(Bill bill);

	public List<Map<String, String>> queryBill(@Param(value="map") Map<String, String> map);

	//根据用户查询账单 or
	public List<Map<String, Object>> queryBillByUserId(Map<String, Object> map);
	/**
	 * 根据任务ID查询账单
	 * @param map
	 * @return
	 */
	public List<Map<String, String>> queryBillByTask(Map<String, String> map);
	/**
	 * 根据条件查询账单信息
	 */
	public List<Map<String, String>> queryBillByOrderOrBill(Map<String, String> map);

	//更新账单
	public int updateBillByBillId(Bill bill);
	/**
	 * 根据订单id和账单类型 查询 另预付款账单的预付款金额
	 */
	public List<Map<String, String>> queryBillByOrderIdAndType(Map<String, String> map);
	/**
	 * 根据账单ID查询账单
	 * @param map
	 * @return
	 */
	public List<Map<String, String>> queryBillByBillId(Map<String, String> map);

	/**
	 * 查询认证付款账单
	 */
	public List<Map<String, String>> queryBillByStateAndType(Map<String, String> map);
}
