package ui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

public class AboutInfo extends JDialog {

	private static final long serialVersionUID = -8980293529600503564L;
	private JEditorPane jEditorPane;
	private Container container;
	public static AboutInfo aboutInfo;

	private AboutInfo() {
		container = this.getContentPane();
		jEditorPane = new JEditorPane("text/html",
				"<html><p>远程控制程序</p><p>ver 1.0</p><font></font></html>");
		jEditorPane.setEditable(false);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("关于本软件--LQ");
		container.setLayout(new BorderLayout());
		container.add(jEditorPane);
		this.setSize(600, 500);
		this.setVisible(true);
	}

	public static AboutInfo getAboutInfo() {
		if (aboutInfo == null) {
			aboutInfo = new AboutInfo();
		} else {
			aboutInfo.setVisible(true);
		}
		return aboutInfo;
	}
}
