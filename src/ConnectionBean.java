import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBean {
	public Connection getConnection(Connection con) {
		try {	
			String user = "201705500317";
			String password = "201705500317";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://172.22.8.235:3306/201705500317a?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8", user, password);
			System.out.println("连接数据库成功！");
		} catch(ClassNotFoundException e1) {
			System.out.println("驱动出错！");
		} catch (SQLException e) {
			System.out.println("连接失败！");
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
				System.out.println("关闭连接成功！");
			} catch (SQLException e) {
				System.out.println("关闭连接失败！");
			}
		}
	}
}
