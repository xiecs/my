package com.xml.xstream.city;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpSender {

	private String url;
	private String encoding = "UTF-8";

	private String sendXml(String xml) {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(url);
		post.addRequestHeader("charset", encoding);
		post.addRequestHeader("ContentType", "text/xml");
		int statusCode = 0;
		try {
			ByteArrayRequestEntity requestEntity = new ByteArrayRequestEntity(xml.getBytes(encoding));
			post.setRequestEntity(requestEntity);
			System.out.println("发送报文-> " + xml);
			statusCode = client.executeMethod(post);
			byte[] responseBody = post.getResponseBody();
			String response = new String(responseBody, encoding);
			System.out.println("接受报文<- " + response);
			if (statusCode == HttpStatus.SC_OK) {
				return response;
			} else {
				return null;
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			post.releaseConnection();
		}
		return null;
	}
}
