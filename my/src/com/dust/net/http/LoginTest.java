package com.dust.net.http;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class LoginTest {

	/**
	 * @param args
	 */
	static String LOGON_SITE = "211.138.251.204";
	static int LOGON_PORT = 80;
	static String inPath = "C:\\msisdn.txt";// �������
	static String outPath = "C:\\result.txt";// ����ļ���
	static String cookieHead = "cod=300; csd=300004; JSESSIONID=862FAFE9451DCE22F3EDA6DD26DD4AB4; JSESSIONID=32554DCB0F0ADA04E3DFBF950A79EA15";
	static String verifyCode="7483";

	public static void main(String[] args) throws Exception {
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT);
		
		// /justone/login_ah.jsp
		PostMethod post = new PostMethod("/justone/login_ah.jsp");
		post.addRequestHeader("Cookie", cookieHead);
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded");
		//Content-Type: application/x-www-form-urlencoded
		// ��¼
		//loginid=31123213&password=321321&verifycode=6396&post=post&submii.x=0&submii.y=0
		NameValuePair arg1 = new NameValuePair("loginid", "1000018793");
		NameValuePair arg2 = new NameValuePair("password", "12345");
		NameValuePair arg3 = new NameValuePair("verifycode", verifyCode);
		NameValuePair arg4 = new NameValuePair("post", "post");
		NameValuePair arg5 = new NameValuePair("submii.x", "0");
		NameValuePair arg6 = new NameValuePair("submii.y", "0");
		post.setRequestBody(new NameValuePair[] { arg1, arg2, arg3, arg4, arg5,arg6 });
		// ��������
		int status = client.executeMethod(post);
		System.out.println("�������״̬��:" + status);
		String body = post.getResponseBodyAsString();
		System.out.println("Ӧ���ģ�" + body);
		// ��������
		post.releaseConnection();
		
//		PostMethod post1 = new PostMethod("/justone/school_management/device_query.jsp");
//		// ��������
//		int status1 = client.executeMethod(post1);
//		System.out.println("�������״̬��:" + status1);
//		String body1 = post1.getResponseBodyAsString();
//		System.out.println("Ӧ���ģ�" + body1);


		// �鿴cookie��Ϣ
		Cookie[] cookies = client.getState().getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			String domain = cookie.getDomain();
			String path = cookie.getPath();
			String argName = cookie.getName();
			String value = cookie.getValue();
			System.out.println("Cookie: " + domain + ", " + path + ", "
					+ argName + ", " + value);
		}

		// // ��½�󣬷�������ҳ��
		// GetMethod get = new GetMethod("http://211.138.251.204/index.jsp");
		// int status = client.executeMethod(get);
		// System.out.println("�������״̬��:" + status);
		// String htmlContent = get.getResponseBodyAsString();
		// System.out.println(htmlContent);
		// get.releaseConnection();


	}

}
