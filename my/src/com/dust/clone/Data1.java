package com.dust.clone;

import java.io.Serializable;

public class Data1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5437903724264946889L;

	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

	public String getBb() {
		return bb;
	}

	public void setBb(String bb) {
		this.bb = bb;
	}

	private String aa = "aa";
	private String bb = "bb";

}
