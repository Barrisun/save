package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    private JLabel label_text;
    private JTextArea textArea;
    private ArrayList<String> numbers; // Список для хранения введенных чисел
    public Main() {
        numbers = new ArrayList<>(); // Инициализация списка
        JFrame frame = new JFrame("Сохранения");
        JLabel label = new JLabel("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(label);

        JButton confirm = new JButton("Подтвердить");
        frame.getContentPane().add(confirm);
        confirm.setBounds(250, 65, 200, 20);

        JButton delete = new JButton("Отчистить 1-ое сообщение");
        frame.getContentPane().add(delete);
        delete.setBounds(250, 85, 200, 20);

        label.setText("Введите текст:");
        label.setBounds(250, 25, 200, 20);

        textArea = new JTextArea("");
        textArea.setBounds(250, 47, 200, 17);
        frame.getContentPane().add(textArea);

        JLabel label1 = new JLabel();
        label1.setText("Сохранения: ");
        label1.setBounds(20, 20, 200, 20);
        frame.getContentPane().add(label1);

        label_text = new JLabel();
        label_text.setBounds(20, -50, 200, 400);
        frame.getContentPane().add(label_text);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textArea.getText();
                if(!input.isEmpty()){
                try {
                    String number = String.valueOf(input);
                    numbers.add(number); // Сохраняем число в список
                    label_text.setText("Сохранено: " + number);
                    textArea.setText(""); // Очищаем текстовое поле
                    updateNumbersDisplay(); // Обновляем отображение сохраненных чисел
                } catch (NumberFormatException ex) {
                    label_text.setText("Ошибка: введите корректное число.");
                }
                }
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                label_text.setText("");
                numbers.remove(0);
                updateNumbersDisplay();
            }
        });
        frame.setVisible(true);
    }

    private void updateNumbersDisplay() {
        // Обновляем отображение сохраненных чисел
        StringBuilder displayText = new StringBuilder("<html>");
        for (String number : numbers) {
            displayText.append(number).append("<br>");

        }
        displayText.append("</html>");
        label_text.setText(displayText.toString());

    }

    public static void main(String[] args) {
        new Main();
    }
}
