import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class SurveyProgressIndicator {
    private JProgressBar progressBar;
    private JTextField nameField;
    private JTextField birthField;
    private JTextField genderField;
    private JTextField numberField;
    private JTextField emailField;
    private JButton submitButton;
    private JLabel nameLabel;
    private JLabel birthLabel;
    private JLabel genderLabel;
    private JLabel numberLabel;
    private JLabel emailLabel;
    private JLabel messageLabel;
    private JPanel Survay;

    JTextField[] fields;

    public SurveyProgressIndicator() {
        submitButton.setPreferredSize(new Dimension(120, 40));
        Survay.setPreferredSize(new Dimension(500, 500));

        progressBar.setName("progressBar");
        nameField.setName("nameField");
        birthField.setName("birthField");
        genderField.setName("genderField");
        numberField.setName("numberField");
        emailField.setName("emailField");
        submitButton.setName("submitButton");
        messageLabel.setName("messageLabel");

        fields = new JTextField[]{nameField, birthField, genderField, numberField, emailField};


        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setValue(0);

        for(JTextField field: fields){
            addTextFieldListener(field);
        }

        submitButton.addActionListener(e -> {
            boolean isEmpty = false;

            for(JTextField field: fields){
                if(field.getText().trim().isEmpty()){
                    isEmpty = true;
                    break;
                }
            }

            if(isEmpty){
                messageLabel.setText("All fields are required");
            } else {
                messageLabel.setText("Thank you for answering");
            }
        });
    }

    private void addTextFieldListener(JTextField field){
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateProgress();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateProgress();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateProgress();
            }

            private void updateProgress() {
                int filledFields = 0;

                for(JTextField f : fields){
                    if(!f.getText().trim().isEmpty()){
                        filledFields++;
                    }
                }

                progressBar.setValue((filledFields * 100) / fields.length);
            }

        });
    }

    static void main(String[] args) {
        JFrame frame = new JFrame("Number Counter");

        SurveyProgressIndicator counter = new SurveyProgressIndicator();

        frame.setContentPane(counter.Survay);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
