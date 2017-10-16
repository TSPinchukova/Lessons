import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private static Connection conn;   //подключение к базе

    public static void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");  //устанавливает соединение со службой mysql
        conn = DriverManager.getConnection("jdbc:mysql://localhost/orange_db", "USER1", "orange100"); //создание подключения
    }

    public static Connection getConnection(){
        return conn;
    }

}

