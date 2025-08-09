

import javax.swing.*;
import java.awt.*;

public class LettersPanel extends JPanel {

    public LettersPanel() {
        setLayout(new BorderLayout());

        // Create the HTML content
        String htmlContent = "<html>"
                + "<body style='font-family: Arial, sans-serif;text-align: center; padding: 20px;'>"
                + "<h2 style='color: blue;'>Kannada Letters / Kannada Alphabets</h2>"
                + "<p>Kannada alphabets are known as Kannada Varnamalegalu.</p>"
                + "Kannada alphabets are classified into three groups and it has 49 (13+2+34) letters.<br><br>"
                + "<ol style='display: inline-block; text-align: left; margin-left: '> "
                + "<li style='margin-bottom: 10px;'>Swaragalu: Vowels (13)</li>"
                + "<li style='margin-bottom: 10px;'>Yogavahagalu: Partly vowel and partly consonant (2)</li>"
                + "<li style='margin-bottom: 10px;'>Vyanjanagalu: Consonants (34)</li>"
                + "</ol>"
                + "<p>Let's start with Swaragalu (Vowels) and then Yogavahagalu (Partly Vowel and Consonants).</p>"
                + "<br><br>"
                + "<body>"
                + "</html>";

        // Label to display the HTML content
        JLabel htmlLabel = new JLabel(htmlContent);
        htmlLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        htmlLabel.setVerticalAlignment(JLabel.CENTER);
        htmlLabel.setHorizontalAlignment(JLabel.CENTER);
        add(htmlLabel, BorderLayout.CENTER);

        // Continue button to move to the next panel (LetterButtonsPanel)
        JButton continueButton = new JButton("Continue");
        continueButton.setFont(new Font("Arial", Font.PLAIN, 18));
        continueButton.setBackground(new Color(0, 123, 255));
        continueButton.setForeground(Color.WHITE);
        continueButton.setPreferredSize(new Dimension(200, 50));
        continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        continueButton.addActionListener(e -> {
            // Transition to Swaragalu Panel
            ((CardLayout) getParent().getLayout()).show(getParent(), "swaragalu");
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(continueButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}

