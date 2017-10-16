import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private static Connection conn;   //подключение к базу

    public static void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");  //устанавливает соединение со службой mysql
        conn = DriverManager.getConnection("jdbc:mysql://localhost/test_db", "USER", "1234love"); //создание подключения
    }

    public static Connection getConnection(){
        return conn;
    }

}
