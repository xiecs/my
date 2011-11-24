package com.dust.net.http;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class GetTest {



	public static void main(String[] args) throws Exception {
		HttpClient client = new HttpClient();
		
//		GET /query?type=yuantong&postid=W207220637&valicode=&temp=0.5572269871714197 HTTP/1.1
//				Accept: */*
//				Accept-Language: zh-cn
//				Referer: http://www.kuaidi100.com/
//				Accept-Encoding: gzip, deflate
//				User-Agent: Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; InfoPath.2)
//				Host: www.kuaidi100.com
//				Connection: Keep-Alive
//				Cookie: Hm_lvt_22ea01af58ba2be0fec7c11b25e88e6c=1295599340457; __utma=87482567.1954488589.1295591305.1295591305.1295599342.2; __utmb=87482567.1.10.1295599342; __utmz=87482567.1295591305.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); Hm_lpvt_22ea01af58ba2be0fec7c11b25e88e6c=1295599340457; ss=1295599342; __utmc=87482567; inputpostid=W207220637; comcode=yuantong


//		GetMethod get = new GetMethod("http://www.kuaidi100.com/query?type=yuantong&postid=W207220637&valicode=&temp=0.5572269871714197");
		
		GetMethod get = new GetMethod("http://www.kuaidi100.com/query?type=yuantong&postid=W207220637&valicode=&temp=0.5572269871714197");
		
		
		get.addRequestHeader("Accept", "*/*");
		get.addRequestHeader("Accept-Language", "zh-cn");
		get.addRequestHeader("Referer", "http://www.kuaidi100.com/");
//		get.addRequestHeader("Accept-Encoding", "gzip, deflate");
		get.addRequestHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; InfoPath.2)");
		get.addRequestHeader("Host", "www.kuaidi100.com");
		get.addRequestHeader("Connection", "Keep-Alive");

		
//		PostMethod post = new PostMethod("/eshopclient/product/show.do?id=111655");
//		post.addRequestHeader("Cookie", cookieHead);


		try {
			System.out.println("��������====");
			int status = client.executeMethod(get);
			System.out.println(status);
			
			//name = new String(name.getBytes("iso-8859-1"), "GB2312");
			//text/html;charset=UTF-8
//			System.out.println(get.getResponseCharSet());
//			byte[] b = get.getResponseBody();
			
			
//			String body=new String(get.getResponseBodyAsString().getBytes(),"UTF-8");
			
//			BufferedReader in = new BufferedReader(new InputStreamReader(get.getResponseBodyAsStream(), "UTF-8"));
//			String line = in.readLine();
//			System.out.println(line);
//			while ((line = in.readLine()) != null) {
//				System.out.println(line);
//			}
			System.out.println("Ӧ���ģ�" + get.getResponseBodyAsString());
//			get.releaseConnection();
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
