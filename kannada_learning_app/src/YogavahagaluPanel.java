import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class YogavahagaluPanel extends JPanel {

    public YogavahagaluPanel() {
        setLayout(new BorderLayout());

        // Panel for Yogavahagalu (Partly vowel, partly consonant)
        JPanel yogavahagaluPanel = new JPanel();
        yogavahagaluPanel.setLayout(new GridLayout(1, 2, 10, 10)); // 2 columns for Yogavahagalu buttons
        yogavahagaluPanel.setBackground(Color.WHITE);

        // Panel for the title
        JPanel yogavahagaluTitlePanel = new JPanel();
        yogavahagaluTitlePanel.setLayout(new BorderLayout());
        yogavahagaluTitlePanel.add(new JLabel("<html><body style='font-family: Arial, sans-serif;text-align: center; padding: 20px;'><h2>Yogavahagalu</h2><br><p>Kannada has 2 letters which are partly vowel and partly consonant. These 2 letters are known as <b>Kannada Yogavahagalu</b>.</p></body></html>", JLabel.CENTER), BorderLayout.CENTER);

        // Add title panel to the main panel
        add(yogavahagaluTitlePanel, BorderLayout.NORTH);

        try {
            // Fetch Yogavahagalu (partly vowel, partly consonant) images and phonetic info
            ResultSet yogavahagalu = DatabaseHelper.getYogavahagalu(); // Fetch yogavahagalu from the database

            // Add buttons for Yogavahagalu
            for (int i = 1; i <= 2; i++) {
                if (yogavahagalu.next()) {
                    String image = yogavahagalu.getString("letter_image");
                    String phonetic = yogavahagalu.getString("english_phonetic");

                    // Create a button for each Yogavahagalu
                    LetterButton yogavahagaluButton = new LetterButton(image, phonetic);

                    // Set a smaller preferred size for each button
                    yogavahagaluButton.setPreferredSize(new Dimension(80, 80)); // Smaller button size (80x80)

                    yogavahagaluPanel.add(yogavahagaluButton);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Add Yogavahagalu panel to the main panel
        JScrollPane yogavahagaluScrollPane = new JScrollPane(yogavahagaluPanel);
        yogavahagaluScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(yogavahagaluScrollPane, BorderLayout.CENTER);

        // Continue button to move to the next panel (LetterButtonsPanel)
        JButton continueButton = new JButton("Continue");
        continueButton.setFont(new Font("Arial", Font.PLAIN, 18));
        continueButton.setBackground(new Color(0, 123, 255));
        continueButton.setForeground(Color.WHITE);
        continueButton.setPreferredSize(new Dimension(200, 50));
        continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        continueButton.addActionListener(e -> {
            // Transition to Swaragalu Panel
            ((CardLayout) getParent().getLayout()).show(getParent(), "testletter");
        });

        // Add the continue button to the bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(continueButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
