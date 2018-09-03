package com.common.config;

import java.util.Properties;

public class Config {
	
	//系统编码  
    public static final String CHARSET = "UTF-8";  
    //系统配置文件的路径  
    public static final String CONFIG_PATH = "/config.properties";  
	
    //********************************************************************//
	private static Properties config = new Properties();  
	
	//根据属性读取配置文件  
    public static String getProperty(String key){  
        return config.getProperty(key);  
    }  
      
    //根据属性写入配置文件  
    public static void setProperty(String key,String value){  
    	config.setProperty(key, value);  
    }
}
