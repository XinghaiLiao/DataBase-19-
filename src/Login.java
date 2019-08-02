import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener{
	JTextField textName = new JTextField();
	JPasswordField textPassword = new JPasswordField();
	JFrame frame;
	
	public void initUI() {
		frame = new JFrame();
		frame.setTitle("Login");
		frame.setSize(new Dimension(400, 350));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		ImageIcon icon = new ImageIcon("src\\img\\loginIcon.png");
		JLabel labIcon = new JLabel(icon);
		labIcon.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
		Container c = frame.getContentPane();
		c.add(labIcon);
		JLabel labName = new JLabel("ÕËºÅ£º");
		c.add(labName);
		textName.setPreferredSize(new Dimension(300, 30));
		c.add(textName);
		JLabel labPassword = new JLabel("ÃÜÂë£º");
		c.add(labPassword);
		c.add(textPassword);
		textPassword.setPreferredSize(new Dimension(300, 30));
		JButton btnLogin = new JButton("µÇÂ½");
		btnLogin.setSize(new Dimension(100, 30));
		frame.add(btnLogin);
		frame.setVisible(true);
		btnLogin.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(!textName.getText().trim().equals("") && !textPassword.getPassword().toString().trim().equals("")) {
			try {
				boolean flag = false;
				ConnectionBean connection = new ConnectionBean();
				Connection con = null;
				con = connection.getConnection(con);
				Statement stmt = con.createStatement();
				String sql = "Select * from labUser";
				ResultSet rs = stmt.executeQuery(sql);
				List<String> nameList = new ArrayList<String>();
				List<String> passwordList = new ArrayList<String>();
				List<Integer> jurisdiction = new ArrayList<Integer>();
				while(rs.next()) {
					nameList.add(rs.getString("ID"));
					passwordList.add(rs.getString("password"));
					jurisdiction.add(rs.getInt("jurisdiction"));
				}
				String name = textName.getText().trim();
				String pwd = new String(textPassword.getPassword());
				for(int i = 0; i < nameList.size(); i++) {
					if(name.equals(nameList.get(i)) && pwd.equals(passwordList.get(i))) {
						int Jurisdiction = jurisdiction.get(i);
						flag = true;
						System.out.println("µÇÂ½³É¹¦");
						connection.closeConnection(con);
						frame.dispose();
						new MainWindow(Jurisdiction);
					} 
				}
				if(flag == false) {
					connection.closeConnection(con);
					JOptionPane.showMessageDialog(frame, "ÓÃ»§Ãû»òÃÜÂë´íÎó£¡", "Ê§°Ü", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(frame, "ÓÃ»§Ãû»òÕßÃÜÂëÎª¿Õ£¡", "´íÎó", JOptionPane.ERROR_MESSAGE);
		}
	}
}
