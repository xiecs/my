package com.io.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.io.message.BaseRequest;
import com.io.message.BaseResponse;
import com.io.message.Ignore;

public class IOUtils {
	protected static Log logger = LogFactory.getLog(IOUtils.class);

	public final static String linkStr = "&";
	public static String charset = "GBK";
	public static int loginFunctionId;// 登录
	public static int logoutFunctionId;// 断开
	public static int checkLinkFunctionId;// 心跳
	private static String userName;
	private static String password;
	public static String desKey;

	// 消息序列编号
	private static int secquence = 0;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws IOSendException
	 */
	@SuppressWarnings("unchecked")
	public static byte[] convertRequestToByte(BaseRequest request) throws Exception {
		StringBuffer content = new StringBuffer();

		Field[] pros = request.getClass().getDeclaredFields();

		if (pros != null) {
			for (Field field : pros) {
				if (field.getName().equals("functionId") || field.getName().equals("messageId")
						|| field.isAnnotationPresent(Ignore.class)) {
					continue;
				}
				Class clz = null;
				try {
					clz = PropertyUtils.getPropertyType(request, field.getName());
				} catch (Exception e) {
					logger.warn(e.getMessage());
				}
				if (clz != null) {
					if (clz.getName().equals("java.lang.String")) {
						try {
							if (content.length() > 0) {
								content.append(linkStr);
							}
							content.append(field.getName().toUpperCase());
							content.append("=");
							content.append(BeanUtils.getProperty(request, field.getName()));
						} catch (Exception e) {
							logger.warn(e.getMessage());
						}
					}
				}
			}
		}
		try {
			String message = content.toString();
			// logger.info("convertSendMessage:" + message);
			return message.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new Exception("转换请求报文错误！");
		}
	}

	public static void convertByteToResponse(byte[] mes, BaseResponse response) throws Exception {

		if (mes.length <= 0) {
			return;
		}

		String message = "";
		try {
			// logger.info(new String(mes));
			message = new String(mes, charset);
		} catch (UnsupportedEncodingException e) {
			throw new Exception("转换应答内容错误！");
		}

		String[] mesArray = message.split(linkStr);

		for (int i = 0; i < mesArray.length; i++) {
			String item = mesArray[i];
			int index = item.indexOf("=");
			String name = item.substring(0, index).toLowerCase();
			String value = item.substring(index + 1).trim();
			try {
				BeanUtils.setProperty(response, name, value);
			} catch (Exception e) {
				logger.warn("设置属性'name'错误！" + e.getMessage());
			}
		}

	}

	/**
	 * 写Int
	 * 
	 * @param n
	 * @return
	 * @throws IOException
	 */
	public static void writeInt(DataOutputStream out, int n) throws IOException {
		byte[] b = new byte[4];
		// b[0] = (byte) (n & 0xff);
		// b[1] = (byte) (n >>> 8 & 0xff);
		// b[2] = (byte) (n >>> 16 & 0xff);
		// b[3] = (byte) (n >>> 24 & 0xff);
		b[3] = (byte) (n & 0xff);
		b[2] = (byte) (n >>> 8 & 0xff);
		b[1] = (byte) (n >>> 16 & 0xff);
		b[0] = (byte) (n >>> 24 & 0xff);
		out.write(b);
	}

	/**
	 * 读Int
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static int readInt(DataInputStream in) throws IOException {
		int ch1 = in.read();
		int ch2 = in.read();
		int ch3 = in.read();
		int ch4 = in.read();
		if ((ch1 | ch2 | ch3 | ch4) < 0)
			throw new EOFException();
		// return ((ch4 << 24) + (ch3 << 16) + (ch2 << 8) + (ch1 << 0));
		return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
	}

	/**
	 * 把整形转成字节数组
	 * 
	 * @param n
	 * @return
	 * @throws IOException
	 */
	public static byte[] intToByteArray(int n) throws IOException {
		byte[] b = new byte[4];
		// b[0] = (byte) (n & 0xff);
		// b[1] = (byte) (n >>> 8 & 0xff);
		// b[2] = (byte) (n >>> 16 & 0xff);
		// b[3] = (byte) (n >>> 24 & 0xff);
		b[3] = (byte) (n & 0xff);
		b[2] = (byte) (n >>> 8 & 0xff);
		b[1] = (byte) (n >>> 16 & 0xff);
		b[0] = (byte) (n >>> 24 & 0xff);
		return b;
	}

	/**
	 * 多个字节数组拼接
	 * 
	 * @param destLength
	 * @param srcByte
	 * @return
	 */
	public static byte[] addByteArrays(int destLength, byte[]... srcByte) {
		// 目标数组
		byte[] dest = new byte[destLength];
		int index = 0;// 目标数组的起始下标
		for (int i = 0; i < srcByte.length; i++) {
			System.arraycopy(srcByte[i], 0, dest, index, srcByte[i].length);
			index += srcByte[i].length;
		}
		return dest;
	}

	public synchronized static int getSecquenceNext() {
		if (secquence > 900000) {
			secquence = 0;
		}
		return ++secquence;
	}

	// public static CheckLinkRequest getCheckLinkRequest() {
	// CheckLinkRequest request = new CheckLinkRequest(checkLinkFunctionId);
	// return request;
	// }
	//
	//
	//
	// public static LoginRequest getLoginRequest() {
	// LoginRequest request = new LoginRequest(loginFunctionId);
	// request.setUser(userName);
	// request.setPass(password);
	// return request;
	// }
	//
	// public static LogoutRequest getLogoutRequest() {
	// LogoutRequest request = new LogoutRequest(logoutFunctionId);
	// return request;
	// }

	/**
	 * 日期转换成字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(date);
	}

	/**
	 * 字符串转换成日期
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date stringToDate(String dateStr) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}// try
		return null;
	}

	public void setCharset(String charset) {
		IOUtils.charset = charset;
	}

	public void setCheckLinkFunctionId(int checkLinkFunctionId) {
		IOUtils.checkLinkFunctionId = checkLinkFunctionId;
	}

	public void setLoginFunctionId(int loginFunctionId) {
		IOUtils.loginFunctionId = loginFunctionId;
	}

	public void setLogoutFunctionId(int logoutFunctionId) {
		IOUtils.logoutFunctionId = logoutFunctionId;
	}

	public void setPassword(String password) {
		IOUtils.password = password;
	}

	public void setUserName(String userName) {
		IOUtils.userName = userName;
	}

	public void setDesKey(String desKey) {
		IOUtils.desKey = desKey;
	}

}
