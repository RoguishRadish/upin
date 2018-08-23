package com.common.config;

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
	
	private static Properties configProp = new Properties();
	//读取配置文件  
    static {
        InputStream inputStream = Config.class.getResourceAsStream(Config.CONFIG_PATH);
        try {
        	configProp.load(inputStream);
            CERT_PATH = configProp.getProperty("CERT_PATH");
			MCH_APPID = configProp.getProperty("MCH_APPID");
			MCHID = configProp.getProperty("MCHID");
			APPID = configProp.getProperty("APPID");
			APPSECRET = configProp.getProperty("APPSECRET");
			SECRET = configProp.getProperty("SECRET");
			IP = configProp.getProperty("IP");
			TRANSFERS_URL=configProp.getProperty("TRANSFERS_URL");
			
			MANYUNTIP=configProp.getProperty("MANYUNTIP");
			inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}