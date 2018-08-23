package com.common.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {

	public static String CERT_PATH ;
	public static String MCH_APPID;
	public static String APPID;
	public static String APPSECRET;//小程序秘钥
	public static String SECRET;
	public static String MCHID;
	public static String IP;
	public static String TRANSFERS_URL;
	
	public static String MANYUNTIP;
	
	static {
		try {
			Properties prop = new Properties();
			InputStream stream = null;
			//stream = new BufferedInputStream(new FileInputStream("D://workspaces/kuaishaoserver_cert/apiclient_cert.p12"));
			
			stream = new BufferedInputStream(new FileInputStream("E://kuaishaoconfing/confing.properties"));
			//stream = new BufferedInputStream(new FileInputStream("D://workspaces/javaworkspace/ksServer/src/confing.properties"));
			prop.load(stream);
			CERT_PATH = prop.getProperty("CERT_PATH");
			MCH_APPID = prop.getProperty("MCH_APPID");
			MCHID = prop.getProperty("MCHID");
			APPID = prop.getProperty("APPID");
			APPSECRET = prop.getProperty("APPSECRET");
			SECRET = prop.getProperty("SECRET");
			IP=prop.getProperty("IP");
			TRANSFERS_URL=prop.getProperty("TRANSFERS_URL");
			
			MANYUNTIP=prop.getProperty("MANYUNTIP");
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
