import com.sun.javafx.sg.prism.NGText;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing");
        frame.setSize(300, 400); //Устанавливает размер 1-ширина,2-высота
        frame.setLocation(100, 100); //Положение окна при запуске
        frame.setVisible(true); //Этот метод делает окно видимым
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // процесс завершается при закрытии
        /*JButton button = new JButton("Press me");
        button.setSize(20,100); // Размер и положение относительно родительского контейнера
        button.setLocation(0,50);
        frame.add(button);*/
        //setBorderLayout(frame);
        //setGridLayout(frame);
        //setAbsoluteLayout(frame);
        setFlowLayout(frame);
    }

    public static void setBorderLayout (JFrame f){
        Container c = f.getContentPane(); // Возвращает объект типа Conteiner
        BorderLayout bl = new BorderLayout(); //создаем шаблон
        c.setLayout(bl);
        JButton button1 = new JButton("1 Press me");
        JButton button2 = new JButton("2 Press me");
        JButton button3 = new JButton("3 Press me");
        JButton button4 = new JButton("4 Press me");
        JButton button5 = new JButton("5 Press me");
        c.add(button1,BorderLayout.NORTH);
        c.add(button2,BorderLayout.CENTER);
        c.add(button3,BorderLayout.WEST);
        c.add(button4,BorderLayout.EAST);
        c.add(button5,BorderLayout.SOUTH);
    }
    /*public static void setFlowLayout (JFrame f){
        Container c = f.getContentPane(); // Возвращает объект типа Conteiner
        FlowLayout fl = new FlowLayout(); //создаем шаблон
        c.setLayout(fl);
        JButton button1 = new JButton("1 Press me");
        JButton button2 = new JButton("2 Press me");
        JButton button3 = new JButton("3 Press me");
        JButton button4 = new JButton("4 Press me");
        JButton button5 = new JButton("5 Press me");
        c.add(button1);
        c.add(button2);
        c.add(button3);
        c.add(button4);
        c.add(button5);
    }*/
    public static void setGridLayout (JFrame f){
        Container c = f.getContentPane(); // Возвращает объект типа Conteiner
        GridLayout gl = new GridLayout(1,2,100,100); //создаем шаблон(1 пар-р - строки, 2 пар-р - столбцы)
        c.setLayout(gl);
        JButton button1 = new JButton("1 Press me");
        JButton button2 = new JButton("2 Press me");
        JButton button3 = new JButton("3 Press me");
        JButton button4 = new JButton("4 Press me");
        JButton button5 = new JButton("5 Press me");
        c.add(button1);
        c.add(button2);
        c.add(button3);
        c.add(button4);
        c.add(button5);
    }
    public static void setAbsoluteLayout (JFrame f){
        Container c = f.getContentPane(); // Возвращает объект типа Conteiner
        c.setLayout(null); //означает, что никакого шаблона нет
        JButton button1 = new JButton("1 Press me");
        JButton button2 = new JButton("2 Press me");
        JButton button3 = new JButton("3 Press me");
        c.add(button1);
        c.add(button2);
        c.add(button3);
        button1.setSize(100, 60);
        button1.setLocation(100, 20);
        button2.setSize(100, 60);
        button2.setLocation(100, 100);
        button3.setSize(100, 60);
        button3.setLocation(100, 180);
    }

    public static void setFlowLayout (JFrame f){
        Container c = f.getContentPane();
        FlowLayout fl = new FlowLayout();
        c.setLayout(fl);
        JLabel lebel = new JLabel("Hello");
        lebel.setText(" Hello world");
        c.add(lebel);
        JTextField textField = new JTextField();
        c.add(textField);
        JPasswordField passwordField= new JPasswordField();
        c.add(passwordField);
        String ps = new String(passwordField.getPassword());
        JProgressBar progressBar = new JProgressBar();
        progressBar.setMinimum(-50); //
        progressBar.setValue(50);  //по умолчанию от 0 до 100
        c.add(progressBar);
        JSlider slider = new JSlider();
        slider.setMinimum(-100);
        slider.setMaximum(100);
        slider.setValue(20); //устанавливает положение бегунка
        c.add(slider);
        slider.setToolTipText("Hello");
        JCheckBox checkBox = new JCheckBox("Check");
        c.add(checkBox);
        checkBox.setSelected(true);
        checkBox.isSelected();
        JRadioButton rb1 = new JRadioButton("Option 1");
        c.add(rb1);
        JRadioButton rb2 = new JRadioButton("Option 2");
        c.add(rb2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        JMenuBar menuBar = new JMenuBar();
        c.add(menuBar);
        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);
        JMenu menuAbout = new JMenu("About");
        menuBar.add(menuAbout);
        JMenuItem menuNew = new JMenu("New");
        JMenuItem menuOpen = new JMenu("Open");
        menuFile.add(menuNew);
        menuFile.add(menuOpen);
        JMenu menuEdit = new JMenu("Edit");
        menuFile.add(menuEdit);
        JMenuItem copyItem = new JMenu("Copy");
        JMenuItem pasteItem = new JMenu("Paste");
        menuEdit.add(copyItem);
        menuEdit.add(pasteItem);






    }

}
