package com.io.service;

import com.io.message.BaseRequest;
import com.io.message.BaseResponse;
import com.io.util.IOUtils;

public class BossService {

	private BaseRequest request;
	private BaseResponse response;

	public BossService(BaseRequest request, BaseResponse response) {
		this.request = request;
		this.response = response;
	}

	public void procc() {
		int messageId = IOUtils.getSecquenceNext();
		request.setMessageId(messageId);
		BossContent content = BossContent.getSingleton();
		content.addRequest(request, response);
		response = content.getResponse(messageId);
	}
}
