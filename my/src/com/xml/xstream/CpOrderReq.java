package com.xml.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("message")
public class CpOrderReq extends Message {
	
	@XStreamAlias("body")
	private ReqBody body;

	public ReqBody getBody() {
		return body;
	}

	public void setBody(ReqBody body) {
		this.body = body;
	}



	
}
