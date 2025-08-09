

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LetterButtonsPanel extends JPanel {

    public LetterButtonsPanel() {
        setLayout(new BorderLayout());

        // Create panels for Swaragalu and Yogavahagalu
        JPanel swaragaluPanel = new JPanel();
        swaragaluPanel.setLayout(new GridLayout(0, 5, 10, 10)); // 3 columns for Swaragalu buttons
        swaragaluPanel.setBackground(Color.WHITE);

        JPanel yogavahagaluPanel = new JPanel();
        yogavahagaluPanel.setLayout(new GridLayout(1, 2, 10, 10)); // 2 columns for Yogavahagalu buttons
        yogavahagaluPanel.setBackground(Color.WHITE);

        // Create a container to hold titles and button panels
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Create a panel for Swaragalu title and add it to the content panel
        JPanel swaragaluTitlePanel = new JPanel();
        swaragaluTitlePanel.setLayout(new BorderLayout());
        swaragaluTitlePanel.add(new JLabel("<html><h3>Swaragalu (Vowels)</h3></html>", JLabel.CENTER), BorderLayout.CENTER);
        contentPanel.add(swaragaluTitlePanel);

       
        // Add the panels to the main layout
        add(contentPanel, BorderLayout.NORTH);

        try {
            // Fetch Swaragalu (vowels) images and phonetic info
            ResultSet vowels = DatabaseHelper.getVowels(); // Fetch vowels from the database

            // Add buttons for Swaragalu (Vowels)
            for (int i = 1; i <= 13; i++) {
                if (vowels.next()) {
                    String image = vowels.getString("letter_image");
                    String phonetic = vowels.getString("english_phonetic");

                    // Create a button with the image for each vowel
                    LetterButton vowelButton = new LetterButton(image, phonetic);
                    swaragaluPanel.add(vowelButton);
                }
            }
            
            // Create a panel for Yogavahagalu title and add it to the content panel
            JPanel yogavahagaluTitlePanel = new JPanel();
            yogavahagaluTitlePanel.setLayout(new BorderLayout());
            yogavahagaluTitlePanel.add(new JLabel("<html><h3>Yogavahagalu</h3></html>", JLabel.CENTER), BorderLayout.CENTER);
            contentPanel.add(yogavahagaluTitlePanel);

            
            // Fetch Yogavahagalu (Partly vowel, partly consonant)
            ResultSet yogavahagalu = DatabaseHelper.getYogavahagalu(); // Fetch yogavahagalu from the database

            // Add buttons for Yogavahagalu
            for (int i = 1; i <= 2; i++) {
                if (yogavahagalu.next()) {
                    String image = yogavahagalu.getString("letter_image");
                    String phonetic = yogavahagalu.getString("english_phonetic");

                    // Create a button with the image for each Yogavahagalu
                    LetterButton yogavahagaluButton = new LetterButton(image, phonetic);
                    yogavahagaluPanel.add(yogavahagaluButton);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Add panels to the main panel
        JScrollPane scrollPane = new JScrollPane(swaragaluPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

        JScrollPane scrollPaneYogavahagalu = new JScrollPane(yogavahagaluPanel);
        scrollPaneYogavahagalu.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPaneYogavahagalu, BorderLayout.SOUTH);
    }
}

