package Process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect_database {
    public static Connection cn;

    public static Connection getCon() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(
            		  "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=qltv;encrypt=true;trustServerCertificate=true",
            		  "javaLibrary",
            		  "nguyen123"
            		);

            System.out.println("✅ Kết nối thành công với SQL Server.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("❌ Kết nối thất bại: " + e.getMessage());
            cn = null;
        }
        return cn;
    }

    public static boolean login(String user, String pass) {
        Connection cn = getCon();
        boolean kq = false;
        if (cn == null) {
            System.err.println("Không thể thực hiện đăng nhập vì kết nối thất bại.");
            return false;
        }

        String sql_login = "SELECT * FROM admin WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql_login);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("✅ Đăng nhập thành công cho tài khoản: " + user);
                kq = true;
            } else {
                System.out.println("⚠️ Tài khoản hoặc mật khẩu không đúng.");
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("❌ Lỗi truy vấn đăng nhập: " + e.getMessage());
        }
        return kq;
    }

    public static void main(String[] args) {
        login("admin", "12345"); // bạn thay giá trị này để test tài khoản
    }
}
