import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Login_form extends JFrame {
    private JTextField login;
    private JPanel panel1;
    public JTextField password;
    private JButton enterButton;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JButton registrationButton;

    public Login_form() throws SQLException, ClassNotFoundException {
        JdbcConnection.init();
        setContentPane(panel1);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Hello", "Title", JOptionPane.WARNING_MESSAGE);//вызываем диалог
                String login = Login_form.this.login.getText();
                String password = Login_form.this.password.getText();
                try{
                    PlayersRep pRep = new PlayersRep();
                    pRep.Login(login, password);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Game_form gf = null;
                try {
                    gf = new Game_form();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                gf.setVisible(true);
                setVisible(false); //у текущего объекта
            }
        });
        registrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); //метод относится к текущему классу
                Registration_form rf = new Registration_form();
                rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                rf.setVisible(true);
                rf.setBounds(10,20,300,400);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
