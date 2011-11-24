package com.xml.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ReqBody extends Body{

	@XStreamAlias("result")
	private int result = 0;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}
