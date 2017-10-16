import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Game_form extends JFrame {
    private JPanel gamePanel;
    private JTextField answerTextField;
    private JButton OKButton;
    private JLabel answerLabel;
    private JButton hintButton;
    private JButton giveUpButton;
    private JPanel AssociationPanel;
    private JLabel tryCountLabel;

    public Game_form() throws SQLException {
        setContentPane(gamePanel);
        setBounds(20,20,300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        QuestionsRep qr = new QuestionsRep();
        questions = qr.getQuestions();
        showNextQuestion();

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answer = answerTextField.getText();
                String correctAnswer = currentQuestion.answer;
                answerTextField.setText("");
                if(answer.equals(correctAnswer)){
                    JOptionPane.showMessageDialog(null, "Вы угадали!","Победа", JOptionPane.INFORMATION_MESSAGE);
                    score += tryCount + 2*hintCount;
                    if (questionNumber==questions.size()){
                        RecordRep rr = new RecordRep();// TODO проверить, последний ли это вопрос
                        try {
                            rr.addRecord(PlayersRep.Player_id, score);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        setVisible(false);
                        Records_form r = null;
                        try {
                            r = new Records_form();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        r.setVisible(true);
                    }else {
                        showNextQuestion();
                    }

                }else {
                    tryCount--;
                    if(tryCount == 0){
                        JOptionPane.showMessageDialog(null, "Вы проиграли. Правильный ответ: "+ currentQuestion.answer," ", JOptionPane.INFORMATION_MESSAGE);
                        // TODO проверить, последний ли это вопрос
                        if (questionNumber==questions.size()){
                            RecordRep rr = new RecordRep();
                            try {
                                rr.addRecord(PlayersRep.Player_id, score);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                            setVisible(false);
                            Records_form r = null;
                            try {
                                r = new Records_form();
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                            r.setVisible(true);
                        }
                    }else {
                        updateTryCountLabelText();
                    }
                }
            }
        });
        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hintCount--;
                associationNumber++;
                String association = currentQuestion.words[associationNumber];
                addAssociation(association);
                if(hintCount==0){
                    hintButton.setEnabled(false);
                }

                updateHintsButtonText();

            }
        });

        giveUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Вы проиграли. Правильный ответ: "+ currentQuestion.answer," ", JOptionPane.INFORMATION_MESSAGE);
                if (questionNumber==questions.size()){
                    RecordRep rr = new RecordRep();
                    try {
                        rr.addRecord(PlayersRep.Player_id, score);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    setVisible(false);
                    Records_form r = null;
                    try {
                        r = new Records_form();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    r.setVisible(true);
                }else {
                    showNextQuestion();
                }
            }
        });
    }

    private int questionNumber = 0;
    private Question currentQuestion;
    private int associationNumber;
    private  int hintCount;
    private int score = 0;

    private ArrayList<Question> questions;
    private void addAssociation(String Assocition){
        JLabel label = new JLabel(Assocition);
        label.setBackground(Color.lightGray);
        label.setForeground(Color.BLACK);
        AssociationPanel.add(label);

        AssociationPanel.updateUI();
    }

    private void showNextQuestion(){
        questionNumber++;
        currentQuestion = questions.get(questionNumber-1);
        AssociationPanel.removeAll(); //чистит от всех элементов, которые были до этого
        associationNumber = 0;
        addAssociation(currentQuestion.words[0]); //показывает 1-ую ассоциацию из этого массива
        hintButton.setEnabled(true);
        tryCount = 10;
        hintCount = currentQuestion.words.length-1;
        updateTryCountLabelText();
        updateHintsButtonText();
    }

    private void updateHintsButtonText(){
        String s = String.format("Подсказки (%d)", hintCount);
        hintButton.setText(s);
    }

    private int tryCount;
    private void updateTryCountLabelText(){
        String s = String.format("У Вас осталось (%d) попыток",tryCount);
        tryCountLabel.setText(s);
    }

}
