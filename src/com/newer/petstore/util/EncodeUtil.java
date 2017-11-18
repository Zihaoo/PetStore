package com.newer.petstore.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodeUtil {

	/**
	 * 工具类
	 * 
	 * @param password
	 * @return
	 */
	public static String md5(String text) {
		try {
			//获得消息摘要（数值）
			byte[] data = MessageDigest.getInstance("MD5").digest(text.getBytes());
			
			//熟知的16进制 1把负数变正数
			return new BigInteger(1,data).toString(16);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(md5("abc"));
		System.out.println(md5(""));
	}
}
