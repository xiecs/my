package com.io.message;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import com.io.util.IOUtils;

/**
 * 接口返回基类，子类属性名全小写。
 * 
 */
public abstract class BaseResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// protected Log logger = LogFactory.getLog(this.getClass());

	/**
	 * 功能号
	 */
	private int functionId;

	/**
	 * 消息编号
	 */
	private int messageId;

	/**
	 * 返回码
	 */
	private int retc;

	/**
	 * 结果描述
	 */
	private String desc;

	/**
	 * 回复内容
	 */
	private String content;

	/**
	 * 读取返回报文
	 * 
	 * @param mes
	 * @throws IOSendException
	 */
	public void setIOMessage(byte[] mes) throws Exception {
		IOUtils.convertByteToResponse(mes, this);
		try {
			content = new String(mes, IOUtils.charset);
		} catch (UnsupportedEncodingException e) {
			// TODO 转换接收报文为字符类型失败的处理
			e.printStackTrace();
		}// try
	}

	public String getContent() {
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

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public int getRetc() {
		return retc;
	}

	public void setRetc(int retc) {
		this.retc = retc;
	}
}
