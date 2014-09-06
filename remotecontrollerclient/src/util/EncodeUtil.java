package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 用于密码或其他字符串的加密
 * 
 * @author LIUQIANG 2014-9-5下午5:27:46
 */
public class EncodeUtil {
	/**
	 * 用于MD5加密
	 * @param str加密前的数据
	 * @return 返回MD5加密后的字符串
	 */
	private static final String createMD5(String str) {
		if (str == null || str.isEmpty())
			return null;
		byte[] byteStr = str.getBytes();
		// 获得MD5算法实例
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance(ClientConstants.KEY_MD5);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 更新摘要
		digest.update(byteStr);
		// 获得密文
		byte[] md = digest.digest();
		// 转换为十六进制数
		StringBuilder builder = new StringBuilder(md.length * 2);
		for (int i = 0; i < md.length; i++) {
			builder.append(ClientConstants.HEX[(md[i] & 0xf0) >>> 4]);
			builder.append(ClientConstants.HEX[md[i] & 0x0f]);
		}
		return builder.toString();
	}

	/**
	 * 用于实现SHA加密
	 * @param str加密前的数据
	 * @return 返回SHA加密后的字符串
	 */
	private static final String createSHA(String str) {
		if (str == null || str.isEmpty())
			return null;
		byte[] byteStr = str.getBytes();
		// 获得MD5算法实例
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance(ClientConstants.KEY_SHA);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 更新摘要
		digest.update(byteStr);
		// 获得密文
		byte[] md = digest.digest();
		// 转换为十六进制数
		StringBuilder builder = new StringBuilder(md.length * 2);
		for (int i = 0; i < md.length; i++) {
			builder.append(ClientConstants.HEX[(md[i] & 0xf0) >>> 4]);
			builder.append(ClientConstants.HEX[md[i] & 0x0f]);
		}
		return builder.toString();
	}

	/**
	 * 密码加密
	 * @param password密码
	 * @return 加密后的密码
	 */
	public static final String passwordEncode(String password) {
		password = createMD5(password);
		password = createSHA(password);
		return password;
	}
}
