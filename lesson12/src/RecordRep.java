import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecordRep {
    public   void addRecord(int id, int score) throws SQLException {
        Connection con = JdbcConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT score FROM records WHERE id_user=?");
        ps.setInt(1, id);
        ResultSet result = ps.executeQuery();
        if(result.next()){
            int prevRecord = result.getInt("score");
            JOptionPane.showMessageDialog(null,"Ваш счет: "+ score, "Счет", JOptionPane.INFORMATION_MESSAGE);
            if(score>prevRecord){
                ps = con.prepareStatement("UPDATE records SET score=?, record_time=NOW() WHERE id_user=?");//NOW - функция возвращает текущее время
                ps.setInt(1, score);
                ps.setInt(2, id);
                ps.executeUpdate();
            }
        } else{
            ps = con.prepareStatement("INSERT INTO records (id_user,score,record_time) VALUES (?,?,NOW())");
            ps.setInt(1, id);
            ps.setInt(2, score);
            ps.executeUpdate();
        }
    }

    public ArrayList<Record>getRecords() throws SQLException {
        Connection con = JdbcConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT login, score, record_time FROM records INNER JOIN players ON records.id_user=players.id ORDER BY score DESC");
        ResultSet result = ps.executeQuery();
        ArrayList<Record> records = new ArrayList<>();
        while (result.next()){
            Record record = new Record();
            record.login = result.getString("login");
            record.score = result.getInt("score");
            record.record_time = result.getString("record_time");

            records.add(record);
        }

        return records;
    }
}
