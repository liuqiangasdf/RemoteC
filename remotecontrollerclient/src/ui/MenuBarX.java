package ui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class MenuBarX extends JMenuBar {

	private static final long serialVersionUID = 8648195999870453299L;
	String[] editItems = new String[] { "Undo", "Cut", "Copy", "Paste" };
	char[] fileShortcuts = { 'N', 'O', 'S', 'X' };
	char[] editShortcuts = { 'Z', 'X', 'C', 'V' };

	public MenuBarX() {

		JMenu fileMenu = new JMenu("文件");
		JMenu optionMenu = new JMenu("选项");
		JMenu helpMenu = new JMenu("帮助");
		JMenu subMenu = new JMenu("SubMenu");
		JMenu subMenu2 = new JMenu("SubMenu2");
		JMenuItem item = null;

		// --------------文件-退出-----------------------------------------------------
		item = new JMenuItem("退出");
		fileMenu.add(item);
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// Assemble the File menus with keyboard accelerators.
		for (int i = 0; i < editItems.length; i++) {
			item = new JMenuItem(editItems[i]);
			item.setAccelerator(KeyStroke
					.getKeyStroke(editShortcuts[i], Toolkit.getDefaultToolkit()
							.getMenuShortcutKeyMask(), false));
			optionMenu.add(item);
		}
		// Insert a separator in the Edit menu in Position 1 after "Undo".
		optionMenu.insertSeparator(1);
		// Assemble the submenus of the Other menu.
		subMenu2.add(item = new JMenuItem("Extra 2"));
		subMenu.add(item = new JMenuItem("Extra 1"));
		subMenu.add(subMenu2);
		// Assemble the Other menu itself.
		optionMenu.add(subMenu);

		optionMenu.add(item = new JCheckBoxMenuItem("Check Me"));

		// ---------------------服务器列表-全部展示-------------------------------------
		optionMenu.addSeparator();
		ButtonGroup buttonGroup = new ButtonGroup();
		optionMenu.add(item = new JRadioButtonMenuItem("全部"));
		item.setSelected(true);
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
		buttonGroup.add(item);
		// ---------------------服务器列表-在线展示-------------------------------------
		optionMenu.add(item = new JRadioButtonMenuItem("在线"));
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
		buttonGroup.add(item);

		// ------------------软件相关信息(About)--------------------------------------
		helpMenu.addSeparator();
		item = new JMenuItem("About", new ImageIcon("image.gif"));
		helpMenu.add(item);
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AboutInfo.getAboutInfo().setLocationRelativeTo(getParent());
			}
		});

		// ------------------------将菜单添加上去---------------------------------------
		add(fileMenu);
		add(optionMenu);
		add(helpMenu);
	}
}
