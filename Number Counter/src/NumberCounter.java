import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberCounter {
    private JPanel NumCounter;
    private JButton increaseButton;
    private JButton decreaceButton;
    private JLabel Number;

    private int count = 0;

    public NumberCounter() {



        //buttons size
        increaseButton.setPreferredSize(new Dimension(120, 40));
        decreaceButton.setPreferredSize(new Dimension(120, 40));

        // Panel Size
        NumCounter.setPreferredSize(new Dimension(400, 300));


        // Display Num
        Number.setText(String.valueOf(count));

        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                Number.setText(String.valueOf(count));
            }
        });

        decreaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                Number.setText(String.valueOf(count));
            }
        });
    }

    static void main(String[] args) {
        JFrame frame = new JFrame("Number Counter");

        NumberCounter counter = new NumberCounter();

        frame.setContentPane(counter.NumCounter);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
