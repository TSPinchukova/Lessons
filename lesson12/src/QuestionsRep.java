import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionsRep {
    public ArrayList<Question>getQuestions() throws SQLException {
        Connection con = JdbcConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM questions ");
        ResultSet result = ps.executeQuery();
        ArrayList<Question>questions = new ArrayList<>();
        while (result.next()){
            Question q = new Question();
            q.id = result.getInt("id");
            q.words = result.getString("words").split(";");//split будет находить элементы и делить строку
            q.answer = result.getString("answer");
            q.answer_img = result.getString("answer_img");
            questions.add(q);
        }
        return questions;
    }

}
