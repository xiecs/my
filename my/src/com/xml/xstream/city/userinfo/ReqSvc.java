package com.xml.xstream.city.userinfo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xml.xstream.city.Svccont;

public class ReqSvc extends Svccont {

	@XStreamAlias("token")
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
