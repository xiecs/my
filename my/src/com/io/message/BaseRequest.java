package com.io.message;

import java.io.Serializable;

import com.io.util.IOUtils;

/**
 * 接口请求基类，子类属性名全小写。
 * 
 */
public abstract class BaseRequest implements Serializable {

	// @Ignore
	// protected Log logger = LogFactory.getLog(this.getClass());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 功能号
	 */
	private int functionId;

	/**
	 * 消息编号
	 */
	private int messageId;

	@Ignore
	private String content;

	/**
	 * 获取发送报文
	 * 
	 * @return
	 * @throws IOSendException
	 */

	public BaseRequest() {
	}

	public BaseRequest(int functionId) {
		this.functionId = functionId;
	}

	public byte[] getIOMessage() throws Exception {
		return IOUtils.convertRequestToByte(this);
	}

	public String getContent() {
		if (null == content) {
			try {
				content = new String(getIOMessage(), IOUtils.charset);
			} catch (Exception e) {
				e.printStackTrace();
			}// try
		}// if
		return content;
	}

	public int getFunctionId() {
		return functionId;
	}

	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
}
