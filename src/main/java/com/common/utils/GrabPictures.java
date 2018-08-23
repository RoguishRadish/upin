package com.common.utils;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GrabPictures {
	
	

	 // 鍦板潃
//    private static final String URL = "http://api.map.baidu.com/place/detail?uid=be67a009dce9788db55f1ea9&output=html&source=placeapi_v2";
//    private static final String URL = "http://588ku.com/";
//    private static final String URL = "http://www.tooopen.com/view/1439719.html";
    // 鑾峰彇img鏍囩姝ｅ垯
    private static final String IMGURL_REG = "<img.*src=(.*?.jpg)[^>]*?>";
    // 鑾峰彇src璺緞鐨勬鍒�
    private static final String IMGSRC_REG = "[a-zA-z]+://[^\\s]*";
    
  

    public static String getPictures(String url) throws Exception{
            //鑾峰緱html鏂囨湰鍐呭
            String HTML = GrabPictures.getHtml(url);
            //鑾峰彇鍥剧墖鏍囩
            List<String> imgUrl = GrabPictures.getImageUrl(HTML);
            //鑾峰彇鍥剧墖src鍦板潃
            List<String> imgSrc = GrabPictures.getImageSrc(imgUrl);
            //http://e.hiphotos.baidu.com/nuomi/pic/item/ac6eddc451da81cb012b2e915b66d01608243198.jpg
            
            if (imgSrc.size() != 0 && !imgSrc.get(0).contains("e.hiphotos.baidu.com")) {
				return imgSrc.get(0);
			}
            return null;
    }
	//鑾峰彇HTML鍐呭
    private static String getHtml(String url)throws Exception{
        URL url1=new URL(url);
        URLConnection connection=url1.openConnection();
        InputStream in=connection.getInputStream();
        InputStreamReader isr=new InputStreamReader(in);
        BufferedReader br=new BufferedReader(isr);

        String line;
        StringBuffer sb=new StringBuffer();
        while((line=br.readLine())!=null){
            sb.append(line,0,line.length());
            sb.append('\n');
        }
        br.close();
        isr.close();
        in.close();
        return sb.toString();
    }
    
  //鑾峰彇ImageUrl鍦板潃
    private static List<String> getImageUrl(String html){
        Matcher matcher=Pattern.compile(IMGURL_REG).matcher(html);
        List<String>listimgurl=new ArrayList<String>();
        while (matcher.find()){
            listimgurl.add(matcher.group());
        }
        return listimgurl;
    }

    //鑾峰彇ImageSrc鍦板潃
    private static List<String> getImageSrc(List<String> listimageurl){
        List<String> listImageSrc=new ArrayList<String>();
        for (String image:listimageurl){
            Matcher matcher=Pattern.compile(IMGSRC_REG).matcher(image);
            while (matcher.find()){
                listImageSrc.add(matcher.group().substring(0, matcher.group().length()-1));
            }
        }
        return listImageSrc;
    }
}
