package com.upin.service.bill.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upin.dao.bill.BillDao;
import com.upin.entity.bill.Bill;
import com.upin.service.bill.BillService;

@Service("billService")
@Transactional
public class BillServiceImpl implements BillService {
	@Autowired
    BillDao billDao;
	
	/**
	 * 新增
	 */
	public void insert(Bill bill){
	    billDao.insert(bill);
	}
	
	/**
	 * 查询
	 * @param map
	 * @return
	 */
	public List<Map<String, String>> queryBill(Map<String, String> map) {
		List<Map<String, String>> list =  billDao.queryBill(map);
		return list;
	}
	
	/**
	 * 根据用户查询账单 or
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> queryBillByUserId(Map<String, Object> map) {
		List<Map<String, Object>> list =  billDao.queryBillByUserId(map);
		return list;
	}
	/**
	 * 根据用户查询账单 or
	 * @param map
	 * @return
	 */
	public List<Map<String, String>> queryBillByTask(Map<String, String> map)  {
		List<Map<String, String>> list =  billDao.queryBillByTask(map);
		return list;
	}
	/**
	 * 根据条件查询账单信息
	 * @param map
	 * @return
	 */
	public List<Map<String, String>> queryBillByOrderOrBill(Map<String, String> map) {
		List<Map<String, String>> list =  billDao.queryBillByOrderOrBill(map);
		return list;
	}

	/**
	 * 更新账单
	 * @param billBase
	 * @return
	 */
	public int updateBillByBillId(Bill bill) {
		return billDao.updateBillByBillId(bill);
		
	}
	/**
	 * 根据订单id和账单类型 查询 另预付款账单的预付款金额
	 * @param map
	 * @return
	 */
	public List<Map<String, String>> queryBillByOrderIdAndType(Map<String, String> map) {
		List<Map<String, String>> list =  billDao.queryBillByOrderIdAndType(map);
		return list;
	}
	/**
	 * 根据账单Id查询账单
	 * @param billMap
	 * @return
	 */
	public List<Map<String, String>> queryBillByBillId(
			Map<String, String> map) {
		List<Map<String, String>> list =  billDao.queryBillByBillId(map);
		return list;
	}

	/**
	 * 查询认证付款账单
	 * @param map
	 * @return
	 */
	public List<Map<String, String>> queryBillByStateAndType(Map<String, String> map) {
		List<Map<String, String>> list =  billDao.queryBillByStateAndType(map);
		return list;
	}

	@Override
	public List<Map<String, String>> getBillList(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, String>> getOneById(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill getOne(String billId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Bill bill) {
		// TODO Auto-generated method stub
		
	}

}
