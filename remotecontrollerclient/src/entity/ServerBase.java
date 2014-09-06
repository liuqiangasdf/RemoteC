package entity;

/**
 * 服务器(被控端)基础 实体类
 * 
 * @author LIUQIANG 2014-9-5下午4:26:41
 */
public class ServerBase {
	/**
	 * 服务器ID
	 */
	private int id;
	/**
	 * 服务器名称
	 */
	private String name;
	/**
	 * 服务器公网地址
	 */
	private String ipAddrOut;
	/**
	 * 服务器内网地址
	 */
	private String ipAddrIn;
	/**
	 * 服务器网卡地址
	 */
	private String mac;
	/**
	 * 服务器状态(0:在线 1:离线 2:异常)
	 */
	private int status = 1;
	/**
	 * 服务器备注
	 */
	private String comment = "";
	/**
	 * 服务器消息
	 */
	private String message = "";

	public ServerBase() {

	}

	public ServerBase(int id, String name, String ipAddrOut, String ipAddrIn,
			String mac, int status, String comment, String message) {
		this.id = id;
		this.name = name;
		this.ipAddrOut = ipAddrOut;
		this.ipAddrIn = ipAddrIn;
		this.mac = mac;
		this.status = status;
		this.comment = comment;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpAddrOut() {
		return ipAddrOut;
	}

	public void setIpAddrOut(String ipAddrOut) {
		this.ipAddrOut = ipAddrOut;
	}

	public String getIpAddrIn() {
		return ipAddrIn;
	}

	public void setIpAddrIn(String ipAddrIn) {
		this.ipAddrIn = ipAddrIn;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
