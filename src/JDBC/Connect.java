package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private static String driver = "com.mysql.jdbc.Driver";
    private Connection conn = null;
    private String url = null;
    private String user = null;
    private String password = null;


    static {
        try {
            Class.forName(driver); //驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("数据库驱动加载失败");
        }
    }


    public Connection getConnection() {
        url ="jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC";
        user = "root";
        password = "root";
        try {
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
        return conn;
    }


    public void closeDB()
    {
        try {
            if(conn != null) {
                conn.close();
                conn = null;
            }
        } catch(Exception e) {
            System.out.println("数据库关闭错误");
            e.printStackTrace();
        }
    }
}
