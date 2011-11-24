package com.dust.net.http;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

public class AccessMpayTest implements Runnable {
	private static int taskCount=1;
	private static int countDown=200;
	private String LOGON_SITE = "211.138.245.150";
	private int LOGON_PORT = 80;
	
//	private String LOGON_SITE = "211.138.251.180";
//	private int LOGON_PORT = 8080;
	
	
	public void post(){
		HttpClient client = new HttpClient();

		PostMethod post = new PostMethod("http://211.138.245.85:8000/sso/POST");
//		PostMethod post = new PostMethod("/eshopclient/product/show.do?id=111655");
//		post.addRequestHeader("Cookie", cookieHead);


		try {
			System.out.println("��������====");
			int status = client.executeMethod(post);
			System.out.println(status);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		taskCount++;
//		countDown--;
	}

	public void run() {
		//while(countDown-->0){
			post();
		//}
	}

}
