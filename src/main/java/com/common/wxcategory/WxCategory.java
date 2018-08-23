package com.common.wxcategory;

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
import com.common.constant.MsgConst;
import com.common.utils.LoadProperties;
import com.upin.entity.token.AccessToken;

/**
 * 微信类
 * @author Administrator
 *
 */
public class WxCategory {
	
	private static Logger logger = LoggerFactory.getLogger(WxCategory.class);
	
	private static final String APP_ID = LoadProperties.APPID;//自己的配置appid  
	private static final String APPSECRET = LoadProperties.APPSECRET;//自己的配置APPSECRET;  
	
	/**
	 * 获取微信openId
	 * getOpenId.get("openId")
     * @param code 识别得到openId必须的一个值  
	 * @return openId
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
            JSONObject openIdJSON = JSONObject.parseObject(response);  
            //openIdJSON可以得到的内容：access_token expires_in  refresh_token openid scope   
            String openId = String.valueOf(openIdJSON.get("openid"));  //openId
            result.put("openId", openId);
            logger.info("openid" + MsgConst.GET_SUCCEED);
        } catch (Exception e) {
        	logger.error("openid" + MsgConst.GET_FAILED);
            e.printStackTrace();
        } finally {  
            client.getConnectionManager().shutdown();  
        }  
        return result;  
    }  
    
    /**
	 * 获取用户access_token
	 * @return String token
	 * @throws Exception
	 */
	public static String getAccessToken() {
		
		String token = "";
		String tokenUrl = WxConst.tokenUrl;
		tokenUrl = tokenUrl + "?grant_type=client_credential&appid=" + APP_ID + "&secret=" + APPSECRET;
		
		HttpClient client = null;
        try {
			client = new DefaultHttpClient();  
			HttpGet httpget = new HttpGet(tokenUrl);  
			ResponseHandler<String> responseHandler = new BasicResponseHandler();  
			String response = client.execute(httpget, responseHandler);  
			JSONObject jsonObject = JSONObject.parseObject(response);  
			//JSON可以得到的内容：access_token 
			token = String.valueOf(jsonObject.get("access_token"));
            logger.info("access_token" + MsgConst.GET_SUCCEED);
		} catch (Exception e) {
			logger.error("access_token" + MsgConst.GET_FAILED);
			e.printStackTrace();
		}
		return token;
	}
	
	/**
	 * 判断token是否过期
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static boolean checkToken(AccessToken token) throws Exception{
		String lastTime = token.getLastTime();// 上次更新时间
		long endDate = System.currentTimeMillis();// 当前时间
		double time = endDate - Long.valueOf(lastTime);
		if (time < 7000000 ) {
			return true;
		}else {
			return false;
		}
	}
}
