package com.uyac.test.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	/**
	 * MD5 密码32小写
	 */
	public static String getMD5Str(String str) {
		StringBuffer buf = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();
			int i;
			buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// Log.e("555","result: " + buf.toString());//32位的加密
			// Log.e("555","result: " + buf.toString().substring(8,24));//16位的加密
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buf.toString();
	}

	private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/**
	 * MD5加密 32大写
	 * 
	 * @param s
	 * @return
	 */
	public static String getMD5(String str) {
		try {
			// Create MD5 Hash
			MessageDigest digest = java.security.MessageDigest
					.getInstance("MD5");
			digest.update(str.getBytes());
			byte messageDigest[] = digest.digest();
			StringBuilder sb = new StringBuilder(messageDigest.length * 2);
			for (int i = 0; i < messageDigest.length; i++) {
				sb.append(HEX_DIGITS[(messageDigest[i] & 0xf0) >>> 4]);
				sb.append(HEX_DIGITS[messageDigest[i] & 0x0f]);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 将MD5字符串 再次自定义处理
	 * 
	 * @param md5Str
	 * @return
	 */
	public static String getMd5PassWord(String md5Str) {
		md5Str = md5Str.replace("1", "");
		md5Str = md5Str.replace("3", "");
		md5Str = md5Str.replace("5", "");
		md5Str = md5Str.replace("7", "");
		md5Str = md5Str.replace("9", "");
		return md5Str;
	}

}
