package com.xml.xstream.city;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.CompactWriter;

public class Ecity {

	@XStreamAlias("msgname")
	private String msgname;
	@XStreamAlias("msgversion")
	private String msgversion;
	@XStreamAlias("transactionid")
	private String transactionid;
	@XStreamAlias("timestamp")
	private String timestamp;
	@XStreamAlias("msgsender")
	private String msgsender;
	@XStreamAlias("result")
	private Result result;

	public String objectToXml(Ecity msg) {
		String h = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		XStream x = new XStream();
		x.processAnnotations(this.getClass());
		OutputStream output = new ByteArrayOutputStream();
		x.marshal(msg, new CompactWriter(new OutputStreamWriter(output)));
		String xml = h + output.toString();
		
		System.out.println(xml);
		
		return xml;
	}

	public Object xmlToObject(String xml) {
		XStream x = new XStream();
		x.processAnnotations(this.getClass());
		Object body = (Object) x.fromXML(xml);
		return body;
	}

	public String getMsgname() {
		return msgname;
	}

	public void setMsgname(String msgname) {
		this.msgname = msgname;
	}

	public String getMsgversion() {
		return msgversion;
	}

	public void setMsgversion(String msgversion) {
		this.msgversion = msgversion;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getMsgsender() {
		return msgsender;
	}

	public void setMsgsender(String msgsender) {
		this.msgsender = msgsender;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
