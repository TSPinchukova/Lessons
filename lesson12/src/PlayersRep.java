import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayersRep {

    public static int Player_id;

    public void Login (String login, String password) throws Exception {
        Connection con = JdbcConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT id FROM players WHERE login=? AND pass_hash=?");
        ps.setString(1,login);
        ps.setString(2,password);
        ResultSet result = ps.executeQuery();
        if(result.next()==false){
            throw new Exception("Неверный логин или пароль");
        }
        PlayersRep.Player_id = result.getInt("id");
    }

    public void Registration (Player p) throws SQLException {
        Connection con = JdbcConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO players (login, pass_hash, age) VALUES (?,?,?)");
        ps.setString(1,p.login);
        ps.setString(2,p.pass_hash);
        ps.setInt(3,p.age);
        ps.executeUpdate();

        ResultSet result = ps.getGeneratedKeys();
        PlayersRep.Player_id = result.getInt(1);
    }

}
