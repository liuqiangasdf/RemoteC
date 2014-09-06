package entity;

import java.util.Date;

/**
 * 服务器扩展类(定义操作等等)
 * 
 * @author LIUQIANG 2014-9-5下午4:33:32
 */
public class Server extends ServerBase {
	/**
	 * 控制密码
	 */
	private String password = "123456";
	/**
	 * 端口号(默认5888)
	 */
	private int port = 5888;
	/**
	 * 添加时间
	 */
	private Date dateOfCreate = new Date();

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Date getDateOfCreate() {
		return dateOfCreate;
	}

	public void setDateOfCreate(Date dateOfCreate) {
		this.dateOfCreate = dateOfCreate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfCreate == null) ? 0 : dateOfCreate.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Server server = (Server) obj;
		if (server.getIpAddrOut().equals(this.getIpAddrOut()) && server.getIpAddrIn().equals(this.getIpAddrIn())
				&& server.getMac().equals(this.getMac())) {
			return true;
		}
		return false;
	}
}
