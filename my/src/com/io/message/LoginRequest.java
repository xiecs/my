package com.io.message;


/**
 * 接口登录
 *
 */
public class LoginRequest extends BaseRequest {

	private static final long serialVersionUID = -3708473863474590652L;

	private String user;

	private String pass;

	public LoginRequest() {
		super();
	}

	public LoginRequest(int functionId) {
		super(functionId);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
