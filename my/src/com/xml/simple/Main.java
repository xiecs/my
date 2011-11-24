package com.xml.simple;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.load.Persister;

public class Main {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Serializer serializer = new Persister();

		CpOrderReq req = new CpOrderReq();
		req.setResult("111");
		
		Message msg = new Message();

		Header header = new Header();
		header.setMsgName("aaaaaa");
		header.setSendAddress("01");
		header.setTransactionIDH("111111111111111");
		header.setTransactionIDO("22222222222");

		msg.setHeader(header);
		msg.setBody(req);

		File result = new File("D://workcode//my//src//com//xml//simple//cpOrderReq.xml");
		
		
		
		serializer.write(msg, result);

	}

}
