import javax.swing.*;
import java.awt.*;

public class SwingApp extends JFrame {
    double value1;
    double value2;
    double result;

    public SwingApp() {
        setTitle("The best calculator ever!");

        JLabel resOut = new JLabel();

        JPanel p2 = new JPanel(new GridLayout(3, 2));
        p2.setBounds(85, 40, 260, 110);
        p2.setPreferredSize(new Dimension(150, 60));

        JTextField tf1 = new JTextField("");
        tf1.addCaretListener(action -> {
            try {
                value1 = Double.parseDouble(tf1.getText());
            } catch (Exception ex) {
                resOut.setText(ex.getMessage());
            }
        });
        tf1.setPreferredSize(new Dimension(150, 30));

        JTextField tf2 = new JTextField("");
        tf2.addCaretListener(action -> {;
        try {
            value2 = Double.parseDouble(tf2.getText());
        } catch (Exception ex) {
            resOut.setText(ex.getMessage());
        }
    });
        tf2.setPreferredSize(new Dimension(150, 30));

        p2.add(new JLabel("1-е число")); p2.add(tf1);
        p2.add(new JLabel("2-е число")); p2.add(tf2);
        p2.add(new JLabel("Результат")); p2.add(resOut);
        add(p2);

        JPanel p1 = new JPanel(new FlowLayout());
        p1.setBounds(-6, 200, 440, 110);
        p1.setPreferredSize(new Dimension(440, 110));
        JButton b1 = new JButton("+");
        b1.addActionListener(action -> {
           result = value1 + value2;
           resOut.setText(String.format("%.4f",result));
        });
        b1.setPreferredSize(new Dimension(100, 100));
        JButton b2 = new JButton("-");
        b2.addActionListener(action -> {
            result = value1 - value2;
            resOut.setText(String.format("%.4f",result));
        });
        b2.setPreferredSize(new Dimension(100, 100));
        JButton b3 = new JButton("/");
        b3.addActionListener(action -> {
            result = value1 / value2;
            resOut.setText(String.format("%.4f",result));
        });
        b3.setPreferredSize(new Dimension(100, 100));
        JButton b4 = new JButton("*");
        b4.addActionListener(action -> {
            result = value1 * value2;
            resOut.setText(String.format("%.4f",result));
        });
        b4.setPreferredSize(new Dimension(100, 100));
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        add(p1);

        setSize(440, 350);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}