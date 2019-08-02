import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ApplyLab extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnReset, btnSubmission;
	private JTextField txtLabId, txtTeacherId, txtTeacherName, txtDate, txtCourse, txtDateEnd;
	
	public ApplyLab() {
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		JPanel p2 = new JPanel();
		p1.add(p2, "North");
		JLabel tip = new JLabel("��*�ı�����д");
		p2.add(tip, JLabel.CENTER);
		tip.setFont(new Font("�����п�", 1, 30));
		tip.setForeground(Color.RED);
		JPanel p3 = new JPanel();
		p1.add(p3, "South");
		btnSubmission = new JButton("�ύ");
		p3.add(btnSubmission);
		btnReset = new JButton("����");
		p3.add(btnReset);
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(7, 3));
		p1.add(p4, "Center");
		p4.add(new JLabel("ʵ����id*"));
		txtLabId = new JTextField();
		p4.add(txtLabId);
		p4.add(new JLabel("������Ҫ�����ʵ���ҵ�id"));
		p4.add(new JLabel("�̹���*"));
		txtTeacherId = new JTextField();
		p4.add(txtTeacherId);
		p4.add(new JLabel("��������Ľ̹���"));
		p4.add(new JLabel("����"));
		txtTeacherName = new JTextField();
		p4.add(txtTeacherName);
		p4.add(new JLabel("�������������"));
		p4.add(new JLabel("�γ�*"));
		txtCourse = new JTextField();
		p4.add(txtCourse);
		p4.add(new JLabel("������ʵ����Ҫ�ϵĿ�"));
		p4.add(new JLabel("רҵ*"));
		JTextField txtMajor = new JTextField();
		p4.add(txtMajor);
		p4.add(new JLabel("������ʵ���רҵ"));
		p4.add(new JLabel("�༶*"));
		JTextField txtClass = new JTextField();
		p4.add(txtClass);
		p4.add(new JLabel("��������ʵ��εİ༶"));
		p4.add(new JLabel("�������Ͽ�ʱ���*"));
		txtDate = new JTextField(5);
		JPanel temp = new JPanel();
		temp.add(txtDate);
		temp.add(new JLabel("-"));
		txtDateEnd = new JTextField(5);
		temp.add(txtDateEnd);
		temp.add(new JLabel("��"));
		p4.add(temp);
		p4.add(new JLabel("������ʵ���ʱ���"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLabId.setText("");
				txtTeacherId.setText("");
				txtTeacherName.setText("");
				txtDate.setText("");
				txtDateEnd.setText("");
				txtMajor.setText("");
				txtClass.setText("");
			}
		});
		btnSubmission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String labid = txtLabId.getText();
				String id =  txtTeacherId.getText();
				String name = txtTeacherName.getText();
				String courses = txtCourse.getText();
				String dateBegin = txtDate.getText();
				String dateE = txtDateEnd.getText();
				String major = txtMajor.getText();
				String sClass = txtClass.getText();
				if(labid.equals("") || id.equals("") || dateBegin.equals("") || dateE.equals("") || courses.equals("")
						|| major.equals("") || sClass.equals("")) {
					JOptionPane.showMessageDialog(ApplyLab.this, "��*�Ĳ���Ϊ��", "��ʾ", JOptionPane.ERROR_MESSAGE);
				} else {
					Connection conn = null;
					Statement stmt = null;
					ConnectionBean connection = new ConnectionBean();
					conn = connection.getConnection(conn);
					String sql = "insert into labapply(labId, tId, course, class, major, tName, dateB, dateEnd) values (" + labid + ", "
							+ id + ", " + "\'" + courses + "\'" + ", " + "\'" + sClass + "\'" + "," + "\'" + major + "\'" + ", " + "\'" + 
							name + "\'" + ", " + dateBegin + ", " + dateE + ")";
					try {
						stmt = conn.createStatement();
						stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(ApplyLab.this, "����ɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						connection.closeConnection(conn);
					}
				}
			}
		});
		this.add(p1);
		this.setVisible(true);
	}
}
