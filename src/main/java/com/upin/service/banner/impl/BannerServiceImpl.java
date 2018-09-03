package com.upin.service.banner.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upin.dao.banner.BannerDao;
import com.upin.dao.bill.BillDao;
import com.upin.entity.bill.Bill;
import com.upin.service.banner.BannerService;
import com.upin.service.bill.BillService;

@Service("bannerService")
@Transactional
public class BannerServiceImpl implements BannerService {
	@Autowired
    BannerDao bannerDao;
	
}
