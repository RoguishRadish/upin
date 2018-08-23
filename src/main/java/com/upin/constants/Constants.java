package com.upin.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 相关常量
 * @author Administrator
 *
 */
public class Constants {
	
	/**
	 * 商品相关
	 */
	public interface Goods{
		public static String GOODS_TYPE_ALL = "0";
		public static String GOODS_TYPE_BANNER = "1";
		public static String GOODS_TYPE_HOT = "2";
	    public static final Map<String, String> GOODS_TYPE_VALUE = new HashMap<String, String>() {
	        /**
			 * 
			 */
			private static final long serialVersionUID = -3635062066951493265L;

			{
	            put(GOODS_TYPE_ALL, "all_goods");
	            put(GOODS_TYPE_BANNER, "banner_goods");
	            put(GOODS_TYPE_HOT, "hot_goods");
	        }
	    };
		/**
		 * 每页显示条数
		 */
		public static String PAGE_SIZE = "5";
		/**
		 * 1下架
		 */
		public static String GOODS_STATUS_DOWN = "1"; 
		/**
		 * 2上架
		 */
		public static String GOODS_STATUS_UPON = "2"; 
		/**
		 * 3完成
		 */
		public static String GOODS_STATUS_FINISH = "3"; 
	}
	
	/**
	 * 订单相关
	 */
	public interface Order{
		/**
		 * 每页显示条数
		 */
		public static String PAGE_SIZE = "10";
	}
	
	/**
	 * 账单相关
	 */
	public interface Bill{
		/**
		 * 每页显示条数
		 */
		public static String PAGE_SIZE = "10";
	}
	
	/**
	 * 收货地址相关
	 */
	public interface Address{
		/**
		 * 每页显示条数
		 */
		public static String PAGE_SIZE = "10";
	}
}
