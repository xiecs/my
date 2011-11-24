package com.io.message;


/**
 * 查询用户信息
 *
 */
public class UserInfoRequest extends BaseRequest {

	private static final long serialVersionUID = -3621447542516994060L;
	/**
	 * 号码
	 */
	private String msisdn;

	public UserInfoRequest() {
		super();
	}

	public UserInfoRequest(int functionId) {
		super(functionId);
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
}
