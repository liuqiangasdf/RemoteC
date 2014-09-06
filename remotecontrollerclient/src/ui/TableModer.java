package ui;

import javax.swing.table.DefaultTableModel;

/**
 * 实现主界面列表，继承后修改
 * 
 * @author LIUQIANG 2014-9-6下午3:34:35
 */
public class TableModer extends DefaultTableModel {

	private static final long serialVersionUID = 1732755812708149082L;

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
