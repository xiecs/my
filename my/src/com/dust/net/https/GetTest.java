package com.dust.net.https;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class GetTest {

	public static void main(String[] args) throws HttpException, IOException {
		// HttpClient client = new HttpClient();
		// GetMethod get = new GetMethod("https://www.verisign.com/");

		// GetMethod get = new GetMethod("https://222.44.51.34:18443/iss.do");

		// GetMethod get = new GetMethod("https://127.0.0.1/tomcat-docs/");

		// GetMethod get = new
		// GetMethod("https://login.taobao.com/member/login.jhtml?f=top&redirectURL=http%3A%2F%2Fwww.taobao.com%2F");

		// try{
		// int status = client.executeMethod(get);
		// System.out.println(status);
		// }catch (Exception e){
		// e.printStackTrace();
		// }
		//
		// System.out.println(get.getResponseBodyAsString());

		URL url = new URL("https://127.0.0.1/service/imageco/invoke.do");

		// System.setProperty("java.protocol.handler.pkgs", "javax.net.ssl");
		// 避免出现 HTTPS hostname wrong

		// 如果回调类检查到主机名可以接受，则允许连接，否则，连接会被终止。
		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {

				return urlHostName.equals(session.getPeerHost());
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
		HttpsURLConnection urlCon = (HttpsURLConnection) url.openConnection();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(urlCon.getInputStream(),"GBK"));
		String line;
		StringBuilder xmlSB = new StringBuilder();
		while ((line = in.readLine()) != null) {
			xmlSB.append(line);
		}
		
	}

}
