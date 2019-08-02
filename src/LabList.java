import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class LabList extends JPanel {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private JButton btnSearch;
	private JTextField txtLabId;
	private JPanel panelNorth;
	
	public LabList() {
		try {
			ConnectionBean connection = new ConnectionBean();
			conn = connection.getConnection(conn);
			stmt = conn.createStatement();
			String sql = "select * from lab";
			rs = stmt.executeQuery(sql);
			String s[] = {"id", "名称", "支持课程", "支持人数"};
			rs.last();
			int k = rs.getRow();
			if(k == 0) {
				JOptionPane.showMessageDialog(this, "你查询的表为空！", "系统提示", JOptionPane.WARNING_MESSAGE);
			} else {
				panelNorth = new JPanel();
				panelNorth.add(new JLabel("实验室id:"));
				txtLabId = new JTextField(10);
				btnSearch = new JButton("查询");
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = txtLabId.getText().trim();
						String sql = "select * from lab where id=" + id;
						int k = 0;
						Connection conn = null;
						Statement stmt = null;
						try {
							ConnectionBean connection = new ConnectionBean();
							conn = connection.getConnection(conn);
							stmt = conn.createStatement();
							rs = stmt.executeQuery(sql);
							rs.last();
							k = rs.getRow();
							if(k == 0) {
								JOptionPane.showMessageDialog(LabList.this, "没有id为" + id + "的实验室哦", "查询结果", JOptionPane.WARNING_MESSAGE);
							} else {
								String name = rs.getString("name");
								String suppCourse = rs.getString("supportCourses");
								String maxStu = rs.getString("maxStu");
								JOptionPane.showMessageDialog(LabList.this, "id:" + id + "\nname:" + name + 
										"\n支持课程:" + suppCourse + "\n最大人数:" + maxStu, "查询结果", JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						} finally {
							connection.closeConnection(conn);
						}
					}
				});
				panelNorth.add(txtLabId);
				panelNorth.add(btnSearch);
				rs.beforeFirst();
				String[][] ob = new String[k][4];
				for(int i = 0; i < k && rs.next(); i++) {
					ob[i][0] = rs.getString("id");
					ob[i][1] = rs.getString("name");
					ob[i][2] = rs.getString("supportCourses");
					ob[i][3] = rs.getString("maxStu");
				}
				JTable table = new JTable(ob, s);
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
