package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;

import entity.Server;

import ui.MenuBarX;
import ui.TableModer;
import util.ClientConstants;
import util.LogUtil;

/**
 * 控制端主界面UI
 * 
 * @author LIUQIANG 2014-9-5下午11:40:52
 */
public class SystemUI extends JFrame {
	private static final long serialVersionUID = -3717968933948826246L;

	private Container panel;
	private JTextArea jTextArea;
	private JTable jTable;
	private JScrollPane jScrollPane_botton;
	private JScrollPane jScrollPane_center;
	private JScrollPane jScrollPane_left;
	private JTabbedPane jTabbedPane_center;
	private JTree jTree_left;
	public static TableModer tableModer_center = new TableModer();

	public SystemUI() {
		LogUtil.infoWrite("控制端启动", ClientConstants.LOG_PATH);
		panel = this.getContentPane();
		panel.setLayout(new BorderLayout(2, 2));

		// --------------------主界面上方菜单显示区域--------------------------------------------------

		// --------------------主界面左面列表显示区域--------------------------------------------------
		jTree_left = new JTree();
		jScrollPane_left = new JScrollPane(jTree_left);
		panel.add(jScrollPane_left, BorderLayout.WEST);

		// --------------------主界面中间列表显示区域--------------------------------------------------
		tableModer_center.setDataVector(ClientConstants.servers,
				ClientConstants.MAIN_TABLE_HEAD);
		jTable = new JTable(tableModer_center);
		jTable.setAutoscrolls(true);
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTable.setFillsViewportHeight(true);
		jScrollPane_center = new JScrollPane();
		jTabbedPane_center = new JTabbedPane(JTabbedPane.TOP);
		jScrollPane_center.getViewport().add(jTable);
		jTabbedPane_center.add("主机列表", jScrollPane_center);
		// jTabbedPane_center.add("主机列表", null);
		panel.add(jTabbedPane_center, BorderLayout.CENTER);

		// --------------------主界面下方详细信息显示区域--------------------------------------------------
		jTextArea = new JTextArea();
		jTextArea.setAutoscrolls(true);
		jTextArea.setEditable(false);
		jTextArea.setRows(10);
		jTextArea.setToolTipText("详细信息");
		jTextArea.setBackground(Color.BLACK);
		jTextArea.setFont(new Font(null, Font.BOLD, 14));
		jScrollPane_botton = new JScrollPane(jTextArea);
		panel.add(jScrollPane_botton, BorderLayout.SOUTH);

		// ----------------------主界面属性配置---------------------------------------------------------
		this.setTitle("远程控制程序-控制端");
		this.setSize(1200, 800);
		this.setLocationRelativeTo(rootPane);
		this.setResizable(false);
		this.setJMenuBar(new MenuBarX());
		// this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Vector<Object> names = new Vector<Object>();
		names.add("主机编号");
		names.add("主机名称");
		names.add("主机IP");
		names.add("主机系统");
		names.add("主机状态");
		names.add("主机备注");
		ClientConstants.MAIN_TABLE_HEAD = names;

		Server server = new Server();
		Vector<String> serverVector = new Vector<String>();
		serverVector.add("1");
		serverVector.add(server.getName());
		serverVector.add(server.getIpAddrOut());
		serverVector.add("win7");
		serverVector.add("在线");
		serverVector.add("测试");

		ClientConstants.servers.add(serverVector);
		SystemUI ui = new SystemUI();
		ui.setVisible(true);
	}
}
