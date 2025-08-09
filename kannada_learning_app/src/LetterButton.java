

import javax.swing.*;
import java.awt.event.ActionListener;

public class LetterButton extends JButton {

    private String phonetic;

    public LetterButton(String image, String phonetic) {
        super(new ImageIcon(image)); // Set the image as the button icon
        this.phonetic = phonetic;
        setToolTipText("Click to see the phonetic sound for this letter");
        addActionListener(e -> showPhonetic(phonetic)); // Display the phonetic sound on click
    }

    private void showPhonetic(String phonetic) {
        JOptionPane.showMessageDialog(this, "Phonetic transcription: " + phonetic);
    }
}

