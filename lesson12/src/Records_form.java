import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Records_form extends JFrame{
    private JPanel recordsPanel;
    private JTextField recordTextField;

    public Records_form() throws SQLException {
        setContentPane(recordsPanel);
        setLocation(100,100);
        setSize(300,400);
        RecordRep rr = new RecordRep();
        ArrayList<Record> records = rr.getRecords();

        System.out.println(records);

        for (Record record: records){
            recordTextField.setText(recordTextField.getText() + record);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
