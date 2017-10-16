import java.util.Date;

public class Record {
    public String login;
    public int score;
    public String record_time;

    @Override
    public String toString(){
        String s = String.format("[%s] %s : %d\n", record_time , login, score);
        return s;
    }
}
