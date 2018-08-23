package com.upin.service.address;

import java.util.List;
import java.util.Map;

import com.upin.entity.address.Address;

public interface AddressService {

	List<Map<String, Object>> getAddressList(Map<String, Object> map);

	List<Map<String, Object>> getAddressDetail(Map<String, Object> map);

	void insert(Address addr);

	void update(Address addr);

}
