package com.newer.petstore.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodeUtil {

	/**
	 * ������
	 * 
	 * @param password
	 * @return
	 */
	public static String md5(String text) {
		try {
			//�����ϢժҪ����ֵ��
			byte[] data = MessageDigest.getInstance("MD5").digest(text.getBytes());
			
			//��֪��16���� 1�Ѹ���������
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
