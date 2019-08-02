import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ApplyList extends JPanel {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private JPanel panelNorth;
	
	public ApplyList() {
		try {
			ConnectionBean connection = new ConnectionBean();
			conn = connection.getConnection(conn);
			stmt = conn.createStatement();
			String sql = "select * from labApply where status = 0";
			rs = stmt.executeQuery(sql);
			String s[] = {"申请id", "实验室", "教师工号", "课程", "教师姓名", "开始周", "结束周", "班级", "专业", "状态"};
			rs.last();
			int k = rs.getRow();
			if(k == 0) {
				JOptionPane.showMessageDialog(this, "没有申请！", "系统提示", JOptionPane.WARNING_MESSAGE);
			} else {
				panelNorth = new JPanel();
				JLabel label = new JLabel("申请状态中0表示未审核，1表示通过，-1表示未通过");
				label.setFont(new Font("华文行楷", 1, 30));
				label.setForeground(Color.RED);
				panelNorth.add(label, JLabel.CENTER);
				rs.beforeFirst();
				String[][] ob = new String[k][10];
				for(int i = 0; i < k && rs.next(); i++) {
					ob[i][0] = rs.getString("id");
					ob[i][1] = rs.getString("labId");
					ob[i][2] = rs.getString("tId");
					ob[i][3] = rs.getString("course");
					ob[i][4] = rs.getString("tName");
					ob[i][5] = rs.getString("dateB");
					ob[i][6] = rs.getString("dateEnd");
					ob[i][7] = rs.getString("class");
					ob[i][8] = rs.getString("major");
					ob[i][9] = rs.getString("status");
				}
				JTable table = new JTable(ob, s);
				table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						int r = table.getSelectedRow();
						JPopupMenu op = new JPopupMenu();
						JMenuItem tongguo = new JMenuItem("通过");
						tongguo.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									ConnectionBean connection = new ConnectionBean();
									Connection conn = null;
									conn = connection.getConnection(conn);
									Object id = table.getValueAt(r, 0);
									String s = id.toString();
									int i = Integer.parseInt(s);
									String sql = "update labApply set status = 1 where id = " + i;
									Statement stmt = conn.createStatement();
									stmt.executeUpdate(sql);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
							}
						});
						JMenuItem butongguo = new JMenuItem("不通过");
						butongguo.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									ConnectionBean connection = new ConnectionBean();
									Connection conn = null;
									conn = connection.getConnection(conn);
									Object id = table.getValueAt(r, 0);
									String s = id.toString();
									int i = Integer.parseInt(s);
									Statement stmt = conn.createStatement();
									String sql = "update labApply set status = -1 where id = " + i;
									stmt.executeUpdate(sql);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
							}
						});
						op.add(tongguo);
						op.addSeparator();
						op.add(butongguo);
						int x = e.getX();
						int y = e.getY();
						op.show(table, x, y);
					}
				});
				table.setSize(new Dimension(700, 700));
				JScrollPane jsp = new JScrollPane(table);
				DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
				tcr.setHorizontalAlignment(JLabel.CENTER);
				table.setDefaultRenderer(Object.class, tcr);
				jsp.setPreferredSize(new Dimension(table.getWidth() - 200, table.getHeight() - 200));
				this.setLayout(new BorderLayout());
				this.add(panelNorth, "North");
				this.add(jsp, "Center");
				this.setVisible(true);
			}
			connection.closeConnection(conn);
		} catch(HeadlessException ex) {
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
