package com.common.utils;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String>{

	 private String htmlUrl;  
	    public TaskWithResult(String htmlUrl){  
	        this.htmlUrl  = htmlUrl;  
	    }  
	      
	    public String call(){  
	    	String  aa=null;
	    	try {
				aa = GrabPictures.getPictures(htmlUrl);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return aa  ;
	    }
}
