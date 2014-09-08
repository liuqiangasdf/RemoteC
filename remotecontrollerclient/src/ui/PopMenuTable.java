package ui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopMenuTable extends JPopupMenu {

	private static final long serialVersionUID = -3187500480622268514L;
	private JMenuItem updateItem;
	private JMenuItem deleteItem;
	private JMenuItem execItem;
	private JMenuItem msgSendItem;
	private JMenuItem showWindowItem;

	public PopMenuTable() {
		updateItem = new JMenuItem("更新");
		deleteItem = new JMenuItem("删除");
		execItem = new JMenuItem("执行CMD");
		msgSendItem = new JMenuItem("发送消息");
		showWindowItem = new JMenuItem("远程监控");

		this.setPopupSize(90, 120);
		this.setBorderPainted(true);

		this.add(updateItem);
		this.addSeparator();
		this.add(execItem);
		this.add(showWindowItem);
		this.add(msgSendItem);
		this.addSeparator();
		this.add(deleteItem);
	}
}
