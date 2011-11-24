package com.io.service;

import com.io.message.BaseRequest;
import com.io.message.BaseResponse;
import com.io.util.IOSendException;

public class BossServerImpl implements IBossServer {

	public BaseResponse send(BaseRequest request, BaseResponse response) throws IOSendException {

		BossService service = new BossService(request, response);
		service.procc();
		return response;
	}

}
