import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestLetterPanel extends JPanel {
    private JRadioButton optionA, optionB, optionC, optionD;
    private JRadioButton optionA2, optionB2, optionC2, optionD2;
    private ButtonGroup optionsGroup, optionsGroup2;
    private JLabel feedbackLabel;

    public TestLetterPanel() {
        setLayout(new BorderLayout());

        // Title label
        JLabel label = new JLabel("Test your Kannada Letters!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        // Panel for the questions and answers
        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS)); // Vertical alignment for questions

        // First Question
        JPanel question1Panel = new JPanel();
        question1Panel.setLayout(new BoxLayout(question1Panel, BoxLayout.Y_AXIS));
        JLabel question1Label = new JLabel("<html>1. Choose the correct transcription for the letter:</html>");
        
        // Loading the image for the first question
        JLabel image1 = new JLabel(new ImageIcon("images/6.png")); // Ensure this path is correct
        question1Panel.add(question1Label);
        question1Panel.add(image1);

        // Options for Question 1
        optionA = new JRadioButton("a. oh");
        optionB = new JRadioButton("b. ru");
        optionC = new JRadioButton("c. uu");
        optionD = new JRadioButton("d. e");

        optionsGroup = new ButtonGroup();
        optionsGroup.add(optionA);
        optionsGroup.add(optionB);
        optionsGroup.add(optionC);
        optionsGroup.add(optionD);

        question1Panel.add(optionA);
        question1Panel.add(optionB);
        question1Panel.add(optionC);
        question1Panel.add(optionD);

        questionPanel.add(question1Panel);

        // Second Question
        JPanel question2Panel = new JPanel();
        question2Panel.setLayout(new BoxLayout(question2Panel, BoxLayout.Y_AXIS));
        JLabel question2Label = new JLabel("<html>2. Choose the correct transcription for the letter:</html>");
        
        // Loading the image for the second question
        JLabel image2 = new JLabel(new ImageIcon("images/y1.png")); // Ensure this path is correct
        question2Panel.add(question2Label);
        question2Panel.add(image2);

        // Options for Question 2
        optionA2 = new JRadioButton("a. aha");
        optionB2 = new JRadioButton("b. amm");
        optionC2 = new JRadioButton("c. i");
        optionD2 = new JRadioButton("d. o");

        optionsGroup2 = new ButtonGroup();
        optionsGroup2.add(optionA2);
        optionsGroup2.add(optionB2);
        optionsGroup2.add(optionC2);
        optionsGroup2.add(optionD2);

        question2Panel.add(optionA2);
        question2Panel.add(optionB2);
        question2Panel.add(optionC2);
        question2Panel.add(optionD2);

        questionPanel.add(question2Panel);

        // Add scrollable panel to prevent overflow/overlap
        JScrollPane scrollPane = new JScrollPane(questionPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Feedback label
        feedbackLabel = new JLabel("", SwingConstants.CENTER);
        feedbackLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        add(feedbackLabel, BorderLayout.SOUTH);

        // Panel for the buttons (Submit, Try Again, Close)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean correct1 = optionC.isSelected(); // Correct answer for the first question is "c"
                boolean correct2 = optionB2.isSelected(); // Correct answer for the second question is "b"

                // Check answers
                if (correct1 && correct2) {
                    JOptionPane.showMessageDialog(TestLetterPanel.this, "You successfully learnt Swaragalu!");
                } else {
                    JOptionPane.showMessageDialog(TestLetterPanel.this, "Some answers are incorrect. Please try again.");
                }
            }
        });

        // Try Again button
        JButton tryAgainButton = new JButton("Try Again");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset the selections
                optionsGroup.clearSelection();
                optionsGroup2.clearSelection();
                feedbackLabel.setText("");
            }
        });

        // Close button (instead of continue)
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the application or the current window
                System.exit(0); // Close the entire application
            }
        });

        buttonPanel.add(submitButton);
        buttonPanel.add(tryAgainButton);
        buttonPanel.add(closeButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
