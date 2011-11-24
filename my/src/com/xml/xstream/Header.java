package com.xml.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Header {

	@XStreamAlias("msgName")
	private String msgName;
	@XStreamAlias("transactionIDO")
	private String transactionIDO;
	@XStreamAlias("transactionIDH")
	private String transactionIDH;
	@XStreamAlias("sendAddress")
	private String sendAddress;

	public String getMsgName() {
		return msgName;
	}

	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}

	public String getTransactionIDO() {
		return transactionIDO;
	}

	public void setTransactionIDO(String transactionIDO) {
		this.transactionIDO = transactionIDO;
	}

	public String getTransactionIDH() {
		return transactionIDH;
	}

	public void setTransactionIDH(String transactionIDH) {
		this.transactionIDH = transactionIDH;
	}

	public String getSendAddress() {
		return sendAddress;
	}

	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}

}
