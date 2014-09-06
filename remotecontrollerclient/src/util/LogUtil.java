package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 用于记录操作日志
 * 
 * @author LIUQIANG 2014-9-5下午8:41:35
 */
public class LogUtil {
	/**
	 * 用于创建文件
	 * 
	 * @param logPath文件路径
	 * @throws IOException
	 */
	private static void createLog(String logPath) throws IOException {
		File file = new File(logPath);
		if (!file.exists()) {
			file.createNewFile();
			errorWrite("文件'" + logPath + "'不存在，创建文件", logPath);
		}
	}

	/**
	 * 用于读取文件内容(暂未使用)
	 * 
	 * @param file要读取的文件
	 * @return 文件内容
	 */
	@SuppressWarnings("unused")
	private static String readFile(File file) {
		String read = "";
		String readStr = "";
		FileReader fileread = null;
		BufferedReader bufread = null;
		try {
			fileread = new FileReader(file);
			bufread = new BufferedReader(fileread);
			while ((read = bufread.readLine()) != null) {
				readStr = readStr + read + "\r\n";
			}
			bufread.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return readStr;
	}

	/**
	 * 将消息写入文件
	 * 
	 * @param file要写入的文件
	 * @param msg要写入的消息
	 * @param append是否追加
	 */
	private static void writeFile(File file, String msg, boolean append) {
		FileWriter writer = null;
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			writer = new FileWriter(file, append);
			writer.write(msg);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将debug信息写入日志
	 * 
	 * @param msg
	 * @param logPath
	 * @return
	 */
	public static void debugWrite(String msg, String logPath) {
		msg = "DEBUG:" + msg + "\r\n";
		try {
			File file = new File(logPath);
			if (!file.exists()) {
				createLog(logPath);
				file = new File(logPath);
			}
			writeFile(file, msg, ClientConstants.APPEND_TRUE);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * 将info信息写入日志
	 * 
	 * @param msg
	 * @param logPath
	 */
	public static void infoWrite(String msg, String logPath) {
		msg = "INFO:" + msg + "\r\n";
		try {
			File file = new File(logPath);
			if (!file.exists()) {
				createLog(logPath);
				file = new File(logPath);
			}
			writeFile(file, msg, ClientConstants.APPEND_TRUE);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * 将error信息写入日志
	 * 
	 * @param msg
	 * @param logPath
	 */
	public static void errorWrite(String msg, String logPath) {
		msg = "ERROR:" + msg + "\r\n";
		try {
			File file = new File(logPath);
			if (!file.exists()) {
				createLog(logPath);
				file = new File(logPath);
			}
			writeFile(file, msg, ClientConstants.APPEND_TRUE);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
