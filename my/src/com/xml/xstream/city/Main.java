package com.xml.xstream.city;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.xml.xstream.city.userinfo.ReqSvc;
import com.xml.xstream.city.userinfo.UserInfoReq;

public class Main {

	public static void main(String[] args) {

		UserInfoReq req = new UserInfoReq();

		ReqSvc reqSvc = new ReqSvc();
		reqSvc.setToken("dsadsadadas");

		req.setMsgname("aaaa");
		req.setReqSvc(reqSvc);

		String xml = req.objectToXml(req);
		// System.out.println(xml);

		// UserInfoReq req1 = new UserInfoReq();
		// XStream x = new XStream();
		// x.processAnnotations(UserInfoReq.class);

		// System.out.println(ToStringBuilder.reflectionToString(x.fromXML(xml)));

		UserInfoReq req1 = new UserInfoReq();
		System.out.println(ToStringBuilder.reflectionToString(req1.xmlToObject(xml)));

	}
}
