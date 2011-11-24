package com.dust.key;

import java.security.MessageDigest;

public class Md5 {
	public static String MD5(String s) {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			// System.out.println("strTemp======" + strTemp.length);
			mdTemp.update(strTemp);

			byte[] md = mdTemp.digest();
			// System.out.println("MD======" + md.length);

			int j = md.length;
			// System.out.println("j====" + j);

			char[] str = new char[j * 2];
			int k = 0;

			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}

			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		// String strMailAddr = "http://211.137.180.84:8080/cgi-bin/login?";
		// long lMillis = System.currentTimeMillis();
		// String strAppendInf = "userid=zhaoqy@jsnewland.com&timestamp=" +
		// lMillis;
		// strMailAddr += (strAppendInf + "&authid=" +
		// MD5("lanhaimima123zhaoqyjsnewland.com" + lMillis));

		System.out.println(MD5("111111"));
		// System.out.println(
		// "com.nl.md5.Md5.MD5(\"lanhaimima123zhaoqyjsnewland.com\" + lMillis).length() = "
		// +
		// Md5.MD5("lanhaimima123zhaoqyjsnewland.com" + lMillis).length());
	}

}