package com.xml.xstream.city.userinfo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xml.xstream.city.Svccont;

public class RespSvc extends Svccont {

	@XStreamAlias("userInfo")
	private UserInfo userInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
