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
	private String port = "5888";
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

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public Date getDateOfCreate() {
		return dateOfCreate;
	}

	public void setDateOfCreate(Date dateOfCreate) {
		this.dateOfCreate = dateOfCreate;
	}
	
	

}
