package com.xml.simple;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Header {

	@Element
	private String msgName;
	@Element
	private String transactionIDO;
	@Element
	private String transactionIDH;
	@Element
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
