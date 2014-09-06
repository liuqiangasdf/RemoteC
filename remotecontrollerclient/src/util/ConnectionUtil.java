package util;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 连接服务器的工具类
 * 
 * @author LIUQIANG 2014-9-5下午11:56:14
 */
public class ConnectionUtil {
	/**
	 * 与被控端建立连接
	 * 
	 * @param addr远程地址
	 * @param rPort远程端口
	 * @param lPort本地端口
	 * @return UDP Socket连接
	 */
	public static DatagramSocket connByUDP(byte[] addr, int rPort, int lPort) {
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(lPort);
			socket.connect(InetAddress.getByAddress(addr), rPort);
			LogUtil.infoWrite("连接'" + InetAddress.getByAddress(addr) + "'成功", ClientConstants.LOG_PATH);
		} catch (SocketException e) {
			LogUtil.errorWrite(e.getMessage(), ClientConstants.LOG_PATH);
			e.printStackTrace();
		} catch (UnknownHostException e) {
			LogUtil.errorWrite(e.getMessage(), ClientConstants.LOG_PATH);
			e.printStackTrace();
		}
		return socket;
	}

	/**
	 * 发送消息给被控端
	 * 
	 * @param socketUDP连接
	 * @param msg消息
	 */
	public static void sendByUDP(DatagramSocket socket, String msg) {
		byte[] data = null;
		DatagramPacket packet = null;
		try {
			data = msg.getBytes();
			packet = new DatagramPacket(data, data.length);
			socket.send(packet);
			LogUtil.infoWrite("发送'" + msg + "'成功", ClientConstants.LOG_PATH);
		} catch (IOException e) {
			LogUtil.errorWrite(e.getMessage(), ClientConstants.LOG_PATH);
			e.printStackTrace();
		}
	}
}
