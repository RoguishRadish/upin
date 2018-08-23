package com.common.utils;

public class DistanceUtil {
	static double DEF_PI = 3.14159265358979323; // PI圆周率
	static double DEF_2PI= 6.28318530712; // 2*PI
	static double DEF_PI180= 0.01745329252; // PI/180.0
	static double DEF_R =6370693.5; //地球半径
	public static double GetShortDistance(double lon1, double lat1, double lon2, double lat2)
	{
		double ew1, ns1, ew2, ns2;
			double dx, dy, dew;
		double distance;
		// 角度转换为弧度
		ew1 = lon1 * DEF_PI180;
		ns1 = lat1 * DEF_PI180;
		ew2 = lon2 * DEF_PI180;
		ns2 = lat2 * DEF_PI180;
		// 经度差
			dew = ew1 - ew2;
			// 若跨东经和西经180 度，进行调整
			if (dew > DEF_PI)
			dew = DEF_2PI - dew;
			else if (dew < -DEF_PI)
			dew = DEF_2PI + dew;
			dx = DEF_R * Math.cos(ns1) * dew; // 东西方向长度(在纬度圈上的投影长度)
			dy = DEF_R * (ns1 - ns2); // 南北方向长度(在经度圈上的投影长度)
			// 勾股定理求斜边长
			distance = Math.sqrt(dx * dx + dy * dy);
			return distance;
		}
		public static double GetLongDistance(double lon1, double lat1, double lon2, double lat2)
		{
			double ew1, ns1, ew2, ns2;
			double distance;
			// 角度转换为弧度
			ew1 = lon1 * DEF_PI180;
			ns1 = lat1 * DEF_PI180;
			ew2 = lon2 * DEF_PI180;
			ns2 = lat2 * DEF_PI180;
			// 求大圆劣弧与球心所夹的角(弧度)
			distance = Math.sin(ns1) * Math.sin(ns2) + Math.cos(ns1) * Math.cos(ns2) * Math.cos(ew1 - ew2);
			// 调整到[-1..1]范围内，避免溢出
			if (distance > 1.0)
			     distance = 1.0;
			else if (distance < -1.0)
			      distance = -1.0;
			// 求大圆劣弧长度
			distance = DEF_R * Math.acos(distance);
			return distance;
		}
		/**  
	     * 计算中心经纬度与目标经纬度的距离（km）  
	     *   
	     * @param centerLon 中心精度  
	     * @param centerLan 中心纬度  
	     * @param targetLon 需要计算的精度  
	     * @param targetLan 需要计算的纬度  
	     * @return km  
	     */    
	    private static final double EARTH_RADIUS = 6378.137;
	    private static double rad(double d){
	        return d * Math.PI / 180.0;
	    }

	    public static double GetDistance(double long1, double lat1, double long2, double lat2) {
	        double a, b, d, sa2, sb2;
	        lat1 = rad(lat1);
	        lat2 = rad(lat2);
	        a = lat1 - lat2;
	        b = rad(long1 - long2);

	        sa2 = Math.sin(a / 2.0);
	        sb2 = Math.sin(b / 2.0);
	        d = 2   * EARTH_RADIUS
	                * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)
	                * Math.cos(lat2) * sb2 * sb2));
	        return d;
	    }
	    
	    /**
		* 距离转换成经度
		* @param distance
		* @return
		*/
	    public static double getLng(double longt1, double lat1, double distance){
	        double a = (180*distance)/(DEF_PI*DEF_R*Math.cos(lat1*DEF_PI/180));
	        return a;
	    }
		/**
		* 距离转换成纬度
		* @param distance
		* @return
		*/
	    public static double getLat(double longt1, double lat1, double distance){
	        double a = (180*distance)/(DEF_PI*DEF_R*Math.cos(lat1*DEF_PI/180));
	        return a;
	    }
}
