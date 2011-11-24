package com.dust.yyt;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class Programme {

	static String LOGON_SITE = "211.138.250.195";
	static int LOGON_PORT = 8080;
	static String cookieHead = "JSESSIONID=KHVFL5n2vTbJv06HPnDdh75XS9nrHb89N9xyQvd9nQ2XLDNBGYDW!1442262972; COOKIE_HASLOGINED=1";

	public static void main(String[] args) throws Exception {
		HttpClient client = new HttpClient();
		int count = 0;
		client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT);
		while (true) {
			// TODO 请求订购页面
			String orderHtml = "/aincs_v2/ido?type=2000";
			GetMethod orderHtmlGet = new GetMethod(orderHtml);
			orderHtmlGet.addRequestHeader("Cookie", cookieHead);
			int orderHtmlStatus = client.executeMethod(orderHtmlGet);
			System.out.println("服务器返回状态码:" + orderHtmlStatus);
			String orderHtmlContent = orderHtmlGet.getResponseBodyAsString();
			System.out.println("订购：" + orderHtmlContent);
			orderHtmlGet.releaseConnection();

			Thread.sleep(2000);
			// TODO 发起订购请求
			String orderArg = "/aincs_v2/selfserv/busimgnt.promchange.action.PromChangeAction?action=submitChgPromMain&actType=&prodName=%B9%E3%B6%AB%B6%A8%CF%F2%C2%FE%D3%CE%D3%C5%BB%DD%B0%FC++&prodid=99100296&subscrModeSel=1";
			System.out.println("开始订购");
			GetMethod orderGet = new GetMethod(orderArg);
			orderGet.addRequestHeader("Cookie", cookieHead);
			int orderStatus = client.executeMethod(orderGet);
			System.out.println("服务器返回状态码:" + orderStatus);
			String orderContent = orderGet.getResponseBodyAsString();
			System.out.println("订购：" + orderContent);
			orderGet.releaseConnection();

			count++;
			System.out.println("总笔数==================" + count);
			Thread.sleep(5000);

			// TODO 请求退订页面
			String cancleHtml = "/aincs_v2/ido?type=2000";
			GetMethod cancleHtmlGet = new GetMethod(cancleHtml);
			cancleHtmlGet.addRequestHeader("Cookie", cookieHead);
			int cancleHtmlStatus = client.executeMethod(cancleHtmlGet);
			System.out.println("服务器返回状态码:" + cancleHtmlStatus);
			String cancleHtmlContent = cancleHtmlGet.getResponseBodyAsString();
			System.out.println(cancleHtmlContent);
			cancleHtmlGet.releaseConnection();

			Thread.sleep(2000);
			// TODO 发起退订请求
			String cancleArg = "/aincs_v2/selfserv/busimgnt.promchange.action.PromChangeAction?action=submitChgPromMain&actType=&prodName=";
			GetMethod cancleGet = new GetMethod(cancleArg);
			cancleGet.addRequestHeader("Cookie", cookieHead);
			int cancleStatus = client.executeMethod(cancleGet);
			System.out.println("服务器返回状态码:" + cancleStatus);
			String cancleContent = cancleGet.getResponseBodyAsString();
			System.out.println(cancleContent);
			cancleGet.releaseConnection();

			count++;
			System.out.println("总笔数==================" + count);
			Thread.sleep(5000);

		}
	}

}
