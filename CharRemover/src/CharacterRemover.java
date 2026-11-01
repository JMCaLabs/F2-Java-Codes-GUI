import javax.swing.*;
import java.awt.*;

public class CharacterRemover {
    private JCheckBox vowelCheckbox;
    private JCheckBox consonantCheckbox;
    private JCheckBox numberCheckbox;
    private JButton removeButton;
    private JButton restoreButton;
    private JPanel CharRemover;
    private JLabel textLabel;

    private String orgtext = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public CharacterRemover() {
        CharRemover.setPreferredSize(new Dimension(450, 300));
        removeButton.setPreferredSize(new Dimension(120, 40));
        restoreButton.setPreferredSize(new Dimension(120, 40));

        removeButton.setText("Remove");
        restoreButton.setText("Restore");
        vowelCheckbox.setText("Vowels");
        consonantCheckbox.setText("Consonant");
        numberCheckbox.setText("Numbers");
        textLabel.setText(orgtext);

        removeButton.addActionListener(e -> {

            String text = orgtext;

            if(vowelCheckbox.isSelected()) {
                text = text.replaceAll("[AEIOU]", "");
            }
            if(consonantCheckbox.isSelected()) {
                text = text.replaceAll("[BDCFGHJKLMNPQRSTVWXYZ]", "");
            }
            if(numberCheckbox.isSelected()) {
                text = text.replaceAll("[0-9]", "");
            }

            textLabel.setText(text);
        });

        restoreButton.addActionListener(e -> {
            textLabel.setText(orgtext);

            vowelCheckbox.setSelected(false);
            consonantCheckbox.setSelected(false);
            numberCheckbox.setSelected(false);
        });

    }

    static void main(String[] args) {
        JFrame frame = new JFrame("Character Remover");
        CharacterRemover charremover = new CharacterRemover();

        frame.setContentPane(charremover.CharRemover);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
