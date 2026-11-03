import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CharacterCounter {
    private JTextArea messageTextArea;
    private JTextField characterTextField;
    private JButton countButton;
    private JLabel countLabel;
    private JPanel CharCounter;

    private File file;



    public CharacterCounter() {

        File folder = new File("src2");
        folder.mkdir();
        File file = new File("src2/file.txt");

        try{
            if (!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error creating file");
        }

        //buttons size
        countButton.setPreferredSize(new Dimension(120, 40));
        characterTextField.setPreferredSize(new Dimension(200, 40));

        CharCounter.setPreferredSize(new Dimension(400, 300));

        messageTextArea.setName("messageTextArea");
        characterTextField.setName("characterTextField");
        countLabel.setName("countLabel");

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ch = characterTextField.getText();

                char target = ch.charAt(0);
                int count = 0;

                try {


                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
                        bw.write(messageTextArea.getText());
                    }
                    try (BufferedReader br = new BufferedReader(new FileReader(file))){
                        int currentChar;
                        while((currentChar = br.read()) != -1) {
                            if((char) currentChar == target){
                                count++;
                            }
                        }
                    }

                    countLabel.setText("Count: " + count);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


    }

    static void main(String[] args) {
        JFrame frame = new JFrame("Character Counter");

        CharacterCounter counter = new CharacterCounter();

        frame.setContentPane(counter.CharCounter);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
