package com.xml.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;


public class Message {

	@XStreamAlias("header")
	private Header header;
	


	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}


	
	public String objectToXml(Message msg) {
		String h = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\r\n";
		XStream x = new XStream();
		x.processAnnotations(this.getClass());
		//x.alias("body", this.getClass());
		//x.alias("body", Body.class);
		String xml = h + x.toXML(msg);
		System.out.println(xml);
		return xml;
	}

}
