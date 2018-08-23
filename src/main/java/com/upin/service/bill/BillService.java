package com.upin.service.bill;

import java.util.List;
import java.util.Map;

import com.upin.entity.bill.Bill;

public interface BillService {

	void insert(Bill bill);

	List<Map<String, String>> queryBillByOrderOrBill(Map<String, String> map);

	List<Map<String, String>> queryBillByBillId(Map<String, String> map);

	List<Map<String, String>> queryBillByOrderIdAndType(Map<String, String> preMap);

	List<Map<String, String>> getBillList(Map<String, String> map);

	List<Map<String, String>> getOneById(Map<String, String> map);

	Bill getOne(String billId);

	void update(Bill bill);
}