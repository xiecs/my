package com.io.service;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import com.io.message.BaseRequest;
import com.io.message.BaseResponse;

public class BossContent {

	private BlockingQueue<BaseRequest> sendPool;// 发送队列
	private Map<Integer, BaseResponse> receivePool;// 接收队列
	private Map<Integer, BaseResponse> hasSendPool;// 已发送队列

	private static BossContent singleton;
	private static final Object syncRoot = new Object();

	private BossContent() {
		sendPool = new ArrayBlockingQueue<BaseRequest>(100, true);
		receivePool = new ConcurrentHashMap<Integer, BaseResponse>();
		hasSendPool = new ConcurrentHashMap<Integer, BaseResponse>();
	}

	public static BossContent getSingleton() {
		if (singleton == null) {
			synchronized (syncRoot) {
				if (singleton == null) {
					singleton = new BossContent();
				}
			}
		}
		return singleton;
	}

	/**
	 * 加入报文发送队列
	 * 
	 * @param request
	 * @param response
	 */
	public void addRequest(BaseRequest request, BaseResponse response) {
		sendPool.add(request);
		hasSendPool.put(request.getMessageId(), response);
	}

	/**
	 * 
	 * @param messageId
	 * @return
	 */
	public BaseResponse getResponse(int messageId) {
		BaseResponse response = null;
		for (int i = 0; i < 10; i++) {
			response = receivePool.get(messageId);
			if (response == null) {
				try {
					Thread.sleep(3000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				return response;
			}
		}
		return null;
	}
	
	public BaseResponse getHasResponse(int messageId) {
		return hasSendPool.get(messageId);
	}

	/**
	 * 获取发送报文
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public BaseRequest getRequest() {
		try {
			return sendPool.size() > 0 ? sendPool.take() : null;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 写入发送完成
	public void setResponse(int messageId, BaseResponse response) {
		receivePool.put(messageId, response);
	}

}
