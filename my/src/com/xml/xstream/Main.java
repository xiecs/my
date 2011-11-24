package com.xml.xstream;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CpOrderReq xml = new CpOrderReq();

		Header header = new Header();
		header.setMsgName("aaaaaa");
		header.setSendAddress("01");
		header.setTransactionIDH("111111111111111");
		header.setTransactionIDO("22222222222");

		ReqBody body = new ReqBody();
		body.setResult(0);

	
		xml.setHeader(header);
		xml.setBody(body);

		String ss = xml.objectToXml(xml);

		/*
		 * XStream x = new XStream(); x.processAnnotations(Message.class);
		 * Message msg = new Message();
		 * 
		 * Header header = new Header(); header.setMsgName("aaaaaa");
		 * header.setSendAddress("01");
		 * header.setTransactionIDH("111111111111111");
		 * header.setTransactionIDO("22222222222");
		 * 
		 * msg.setHeader(header); msg.setBody(xml);
		 * 
		 * x.alias("body",CpOrderReq.class);
		 * 
		 * String str = x.toXML(msg);
		 * 
		 * System.out.println(str);
		 */

	}

}
