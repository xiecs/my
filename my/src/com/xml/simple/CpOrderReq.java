package com.xml.simple;

import org.simpleframework.xml.Element;


public class CpOrderReq extends Body {

	@Element
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
