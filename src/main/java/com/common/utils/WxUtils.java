package com.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.common.wxcategory.WxConst;
import com.sun.xml.internal.txw2.Document;

/**
 * 微信方法类
 * @author Administrator
 *
 */
public class WxUtils {
	
	private static Logger logger = LoggerFactory.getLogger(WxUtils.class);
	
	private static final Object HttpRequester = null;
	private static final String APP_ID = LoadProperties.APPID;//自己的配置appid  
	private static final String APPSECRET = LoadProperties.APPSECRET;//自己的配置APPSECRET;  
	private static final Document Jsop = null;
	
	/**
	 * 获取微信openId
     * @param code 识别得到openID必须的一个值  
	 * @return
	 */
    public static Map<String, String> getOpenId(String code) {  
        String openUrl = WxConst.openUrl;//获取openId的URL
        
        openUrl = openUrl +"?appid="+ APP_ID +"&secret="+ APPSECRET +"&grant_type=authorization_code&js_code="+ code;

        HttpClient client = null;  
        Map<String,String> result =new HashMap<String,String>();  
        try {     
            client = new DefaultHttpClient();  
            HttpGet httpget = new HttpGet(openUrl);  
            ResponseHandler<String> responseHandler = new BasicResponseHandler();  
            String response = client.execute(httpget, responseHandler);  
            JSONObject openIdJSONO = JSONObject.parseObject(response);  
            
            System.out.println("response--"+response);
              
            //OpenidJSONO可以得到的内容：access_token expires_in  refresh_token openid scope   
            String openId =String.valueOf(openIdJSONO.get("openid"));  //openId
//            String accessToken=String.valueOf(openIdJSONO.get("access_token"));  
//            String refresh_token=String.valueOf(openIdJSONO.get("refresh_token"));  
              
            result.put("openId", openId);  
//            result.put("accessToken", accessToken);  
//            result.put("refresh_token", refresh_token);  
        } catch (Exception e) {  
            e.printStackTrace();   
        } finally {  
            client.getConnectionManager().shutdown();  
        }  
        return result;  
    }  
    
    /**
	 * 获取用户ACCESS_TOKEN
	 * @return
	 * @throws Exception
	 */
	public static String getAccessToken() throws Exception {
		
		String token = "";
		String tokenUrl = WxConst.tokenUrl;
		
		tokenUrl = tokenUrl + "?grant_type=client_credential&appid=" + APP_ID + "&secret=" + APPSECRET;
		System.out.println("======tokenUrl:" + tokenUrl);
		
		HttpClient client = null;  
        client = new DefaultHttpClient();  
        HttpGet httpget = new HttpGet(tokenUrl);  
        ResponseHandler<String> responseHandler = new BasicResponseHandler();  
        String response = client.execute(httpget, responseHandler);  
        JSONObject jsonObject = JSONObject.parseObject(response);  
          
        //JSONO可以得到的内容：access_token 
        token = String.valueOf(jsonObject.get("access_token"));  
		
		
		return token;
	}
}
