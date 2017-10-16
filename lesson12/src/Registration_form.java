import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class Registration_form extends JFrame{
    private JTextField loginTextField;
    private JPanel panel1;
    private JTextField passwordTextField;
    private JTextField repeat_passwordTextField;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JTextField ageTextField;
    private JLabel ageLabel;
    private JLabel repeat_passwordLabel;
    private JButton registrationButton;

    public Registration_form(){
        setContentPane(panel1);

        registrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // просто текст - TextField, то passwordField.getText();
                // пароль PasswordField, то new String(passwordField.getPassword();
                if(loginTextField.getText().length()==0||passwordTextField.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Все поля должны быть заполнены", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String password = passwordTextField.getText();
                String repeatPassword = repeat_passwordTextField.getText();
                if(password.equals(repeatPassword)==false){
                    JOptionPane.showMessageDialog(null, "Пароли должны совпадать", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int age;
                String ageString = ageTextField.getText();
                try{
                    age = Integer.parseInt(ageString);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Возраст указан неверно", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(age<4||age>99){
                    JOptionPane.showMessageDialog(null, "Возраст должен быть в диапозоне от 4 до 99", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //Создать объект типа Player
                Player p = new Player();
                p.login = loginTextField.getText();
                p.pass_hash = passwordTextField.getText();
                p.age = age;
                PlayersRep pr = new PlayersRep();
                try {
                    pr.Registration(p);
                }catch (SQLIntegrityConstraintViolationException e1){
                    JOptionPane.showMessageDialog(null,"Пользователь с таким логином уже существует", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Ошибка регистрации", "ERROR", JOptionPane.ERROR_MESSAGE);
                } ;
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
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
