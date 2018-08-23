package com.upin.service.goods.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upin.dao.goods.GoodsDao;
import com.upin.service.goods.GoodsService;

@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	GoodsDao goodsDao;

	@Override
	public List<Map<String, String>> getOneById(Map<String, String> map) {
		List<Map<String, String>> goods = goodsDao.getOneById(map);
		return goods;
	}

	@Override
	public List<Map<String, String>> getPicUrls(Map<String, Object> map) {
		List<Map<String, String>> picUrlList = goodsDao.getPicUrls(map);
		return picUrlList;
	}
	
	@Override
	public List<Map<String, Object>> getGoodsList(Map<String, Object> map) {
		List<Map<String, Object>> list = goodsDao.getGoodsList(map);
		return list;
	}
}
