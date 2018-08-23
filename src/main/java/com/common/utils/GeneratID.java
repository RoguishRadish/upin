package com.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成id
 * @author Administrator
 *
 */
public class GeneratID {
	
	/**
    * 根据传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
    *
    * @param sformat
    *            yyyyMMddHHmmssSSS
    * @return
    */
    public static String getDate(String sformat) {
       Date currentTime = new Date();
       SimpleDateFormat formatter = new SimpleDateFormat(sformat);
       String dateString = formatter.format(currentTime);
       return dateString;
    }

    public static String getRandomNum(int num){
        String numStr = "";
        for(int i = 0; i < num; i++){
            numStr += (int)(10*(Math.random()));
        }
        return numStr;
    }
    /**
     * 生成id
     * yyyyMMddHHmmssSSS + 000
     * @return String id
     */
    public static String getGeneratID(){
        String sformat = "yyyyMMddHHmmssSSS";
        int num = 3;
        String id = getDate(sformat) + getRandomNum(num);
        return id;
    }
}
