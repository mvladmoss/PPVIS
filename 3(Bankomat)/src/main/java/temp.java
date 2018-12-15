import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class temp {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/base?useSSL=false", "root", "6021252");
    }
}
