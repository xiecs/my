package com.xml.xstream.city.userinfo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xml.xstream.city.Ecity;

@XStreamAlias("ecity")
public class UserInfoResp extends Ecity {

	@XStreamAlias("svccont")
	private RespSvc respSvc;

	public RespSvc getRespSvc() {
		return respSvc;
	}

	public void setRespSvc(RespSvc respSvc) {
		this.respSvc = respSvc;
	}

}
