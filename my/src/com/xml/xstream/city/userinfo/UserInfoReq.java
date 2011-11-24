package com.xml.xstream.city.userinfo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xml.xstream.city.Ecity;

@XStreamAlias("ecity")
public class UserInfoReq extends Ecity {

	@XStreamAlias("svccont")
	private ReqSvc reqSvc;

	public ReqSvc getReqSvc() {
		return reqSvc;
	}

	public void setReqSvc(ReqSvc reqSvc) {
		this.reqSvc = reqSvc;
	}
	
	

}
