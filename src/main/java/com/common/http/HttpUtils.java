package com.common.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyStore;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
//import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

/**
 * 创建时间：2016年11月9日 下午4:16:32
 * 
 * @author andy
 * @version 2.2
 */
public class HttpUtils {
	public static String wxAppPostHttp(String reqURL, String mch_id, String sEntity) {
		String responseContent = null; // 响应内容
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			try {
				HttpPost httppost = new HttpPost(reqURL);
				// System.out.println("executing request" + httppost.getRequestLine());
				httppost.setEntity(new StringEntity(sEntity, "UTF-8"));
				CloseableHttpResponse response = httpclient.execute(httppost);
				try {
					HttpEntity entity = response.getEntity(); // 获取响应实体
					if (null != entity) {
						responseContent = EntityUtils.toString(entity, "UTF-8");
						EntityUtils.consume(entity); // Consume response content
					}
				} finally {
					response.close();
				}
			} finally {
				httpclient.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseContent;
	}

	public static String postHttp(String reqURL, String mch_id, String sEntity) {
		String responseContent = null; // 响应内容
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			FileInputStream instream = new FileInputStream(new File("E://kuaishaoserver_cert/apiclient_cert.p12"));
			try {
				keyStore.load(instream, mch_id.toCharArray());
			} finally {
				instream.close();
				// logger.info("证书加载失败，请检查证书文件是否正确，以及证书密码是否已修改！");
			}

			// sEntity = "<xml>"+
			// "<amount>2</amount>"+
			// "<check_name>NO_CHECK</check_name>"+
			// "<desc>测试转账到个人</desc>"+
			// "<mch_appid>wx121d66b8b3ee234d</mch_appid>"+
			// "<mchid>1484257292</mchid>"+
			// "<nonce_str>7eQ6DajyH6EchsAkSeoHIPwD5CEhjqCj</nonce_str>"+
			// "<openid>oCgXu0CbdNNQWoBHmaFItV9Ris9o</openid>"+
			// "<partner_trade_no>1234567890</partner_trade_no>"+
			// "<spbill_create_ip>172.17.169.98</spbill_create_ip>"+
			// "<sign>CB5D43A7016DB30B3F59023597982F1D</sign>"+
			// "</xml>";

			SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, mch_id.toCharArray()).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
					null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			try {
				HttpPost httppost = new HttpPost(reqURL);
				// System.out.println("executing request" + httppost.getRequestLine());
				httppost.setEntity(new StringEntity(sEntity, "UTF-8"));
				CloseableHttpResponse response = httpclient.execute(httppost);
				try {
					HttpEntity entity = response.getEntity(); // 获取响应实体
					if (null != entity) {
						responseContent = EntityUtils.toString(entity, "UTF-8");
						EntityUtils.consume(entity); // Consume response content
					}
				} finally {
					response.close();
				}
			} finally {
				httpclient.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseContent;
	}
	
	/**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return String 所代表远程资源的响应结果
     */
    public static String get(String url,String param){
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            //System.out.println(urlNameString);
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            /*for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }*/
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}