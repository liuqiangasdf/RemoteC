package util;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Vector;

import main.SystemUI;

import entity.Server;

/**
 * 监听被控端上线,显示在主界面列表中
 * 
 * @author LIUQIANG 2014-9-6上午11:52:58
 */
public class UDPListener implements Runnable {

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		DatagramSocket client = null;
		DatagramPacket data = null;
		byte[] buffer = new byte[512];
		String str = null;
		try {
			client = new DatagramSocket(ClientConstants.LOCAL_CONN_PORT);
			data = new DatagramPacket(buffer, buffer.length);
			client.setSoTimeout(1000 * 30);
			while (true) { // 一直监听
				client.receive(data);
				str = new String(data.getData());
				String ip = data.getAddress().getHostAddress();
				int port = data.getPort();
				String name = data.getAddress().getHostName();
				LogUtil.infoWrite(data.getAddress().getHostAddress() + " : "
						+ str, ClientConstants.LOG_PATH);
				// 收到被控端上线消息，更新控制端列表
				Server server = new Server();
				server.setPort(port);
				server.setIpAddrOut(ip);
				server.setName(name);
				server.setStatus(0);
				Vector<String> serverVector = new Vector<String>();
				serverVector.add(ClientConstants.servers.size() + "");
				serverVector.add(server.getName());
				serverVector.add(server.getIpAddrOut());
				serverVector.add("win7");
				serverVector.add("在线");
				serverVector.add("测试");
				Vector<String> temp = null;
				for (int i = 0; i < ClientConstants.servers.size(); i++) {
					temp = (Vector<String>) ClientConstants.servers.get(i);
					if (temp.get(3).equals(ip)) {
						temp.set(5, "在线");
						ClientConstants.servers.set(i, temp);
					} else {
						ClientConstants.servers.add(serverVector);
					}
				}
				SystemUI.tableModer_center.fireTableDataChanged();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
