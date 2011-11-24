package com.io.message;


public class UserInfoResponse extends BaseResponse {

	private static final long serialVersionUID = -8272483148044976207L;

	private String regioncode;//归属地市
	private String brand;//品牌
	private String vipflag;//VIP标志
	private String creditclass;//信用度
	private String custname;//客户名称
	
//	@Ignore
//	private String userid;//用户编号,内部使用,亚信改了名,以后用serv_id
	
	private String serv_id;//用户编号

	public String getServ_id() {
		return serv_id;
	}

	public void setServ_id(String servId) {
		serv_id = servId;
	}

	public String getUserid() {
		return serv_id;
	}

	public void setUserid(String userid) {
		this.serv_id = userid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCreditclass() {
		return creditclass;
	}

	public void setCreditclass(String credit) {
		this.creditclass = credit;
	}

	public String getRegioncode() {
		return regioncode;
	}

	public void setRegioncode(String regioncode) {
		this.regioncode = regioncode;
	}

	public String getVipflag() {
		return vipflag;
	}

	public void setVipflag(String vipflag) {
		this.vipflag = vipflag;
	}

	 public String getCustname() {
	 return custname;
	 }
	
	 public void setCustname(String custname) {
	 this.custname = custname;
	 }
}
