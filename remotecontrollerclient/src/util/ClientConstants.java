package util;

import java.util.Vector;

import entity.Server;

/**
 * 用于控制端的常量类
 * 
 * @author LIUQIANG 2014-9-5下午8:02:18
 */
public final class ClientConstants {

	// -------------------------------------加密之后转换为十六进制数-----------------------------------------------------------------
	public static final char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	// ------------------------------------------加密算法------------------------------------------------------------------------
	public static final String KEY_MD5 = "md5";
	public static final String KEY_SHA = "sha";

	// ------------------------------------------日志操作------------------------------------------------------------------------
	public static final String LOG_PATH = "c:/remotecontrol_log.txt";
	public static final boolean APPEND_TRUE = true;
	public static final boolean APPEND_FALSE = false;

	// ------------------------------------------连接端口------------------------------------------------------------------------
	public static final int REMOTE_CONN_PORT = 5888;// 上下线端口
	public static final int LOCAL_CONN_PORT = 5888;
	public static final int REMOTE_UI_PORT = 5889;// 屏幕监控端口
	public static final int LOCAL_UI_PORT = 5889;
	public static final int REMOTE_EXEC_PORT = 5890;// 命令传输端口
	public static final int LOCAL_EXEC_PORT = 5890;
	public static final int REMOTE_MSG_PORT = 5891;// 消息传输端口
	public static final int LOCAL_MSG_PORT = 5891;

	// ------------------------------------------主界面列表信息--------------------------------------------------------------------
	public static Vector<Object> MAIN_TABLE_HEAD = new Vector<Object>();
	public static Vector<Server> servers = new Vector<Server>();
}
