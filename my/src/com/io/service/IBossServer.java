package com.io.service;

import com.io.message.BaseRequest;
import com.io.message.BaseResponse;
import com.io.util.IOSendException;


/**
 * 提供给客户端调用的BOSS接口
 * @author xiecs
 *
 */
public interface IBossServer {
	/**
	 * 发送报文
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOSendException
	 */
	BaseResponse send(BaseRequest request, BaseResponse response)
			throws IOSendException;

}
