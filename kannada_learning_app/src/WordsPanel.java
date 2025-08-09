import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WordsPanel extends JPanel {

    public WordsPanel() {
        setLayout(new GridLayout(0, 1));

        try {
            ResultSet words = DatabaseHelper.getWords(); // Fetch words from database
            while (words.next()) {
                String word = words.getString("word_name");
                String meaning = words.getString("word_meaning");

                // Create a button for each word
                JButton wordPanelButton = new JButton(word);
                wordPanelButton.addActionListener(e -> showMeaning(word, meaning));
                add(wordPanelButton); // Add the button to the panel
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Display the meaning of the word
    private void showMeaning(String word, String meaning) {
        JOptionPane.showMessageDialog(this, word + " means: " + meaning);
    }
}
