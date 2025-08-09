
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroductionPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public IntroductionPanel(CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

        // Set layout with padding between components
        setLayout(new BorderLayout(20, 20)); // Increased padding between components
        setBackground(Color.WHITE);

        // Create the HTML content with a simple table
        String htmlContent = "<html>"
                + "<h2>These are the  steps  you will go through to learn kannada:</h2>"
                + "<div style='text-align: center; padding: 20px;'>"
                + "<h2>Learning Steps</h2>"
                + "<table border='1' cellpadding='10' cellspacing='0' style='border-collapse: collapse; margin: auto;'>"
                + "<tr style='background-color: #f0f8ff;'>"
                + "<th>Step</th><th>Description</th>"
                + "</tr>"
                + "<tr><td>1</td><td>Introduction</td></tr>"
                + "<tr><td>2</td><td>Learn Letters</td></tr>"
                + "<tr><td>3</td><td>Test on Letters</td></tr>"
                + "<tr><td>4</td><td>Words</td></tr>"
                + "<tr><td>5</td><td>Test on Words</td></tr>"
                + "</table>"
                + "</div>"
                + "</html>";

        // JEditorPane to display HTML content
        JEditorPane htmlPane = new JEditorPane("text/html", htmlContent);
        htmlPane.setEditable(false);  // Make the editor read-only
        htmlPane.setBackground(Color.WHITE);
        htmlPane.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font for the HTML content

        // Remove the JScrollPane and directly add the JEditorPane to the panel
        JPanel tableContainer = new JPanel(new FlowLayout(FlowLayout.CENTER)); // This will center the table
        tableContainer.setBackground(Color.WHITE);
        tableContainer.add(htmlPane); // Add the JEditorPane directly to the container
        tableContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add margin around the table container

        // Styling the Continue Button
        JButton continueButton = new JButton("Continue");
        continueButton.setFont(new Font("Arial", Font.PLAIN, 18));
        continueButton.setForeground(Color.WHITE);
        continueButton.setBackground(new Color(0, 123, 255)); // Blue background
        continueButton.setFocusPainted(false);
        continueButton.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2)); // Border for button
        continueButton.setPreferredSize(new Dimension(200, 50)); // Set button size
        continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand on hover

        // Adding hover effect on the button
        continueButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                continueButton.setBackground(new Color(0, 102, 204)); // Darker blue on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                continueButton.setBackground(new Color(0, 123, 255)); // Original blue
            }
        });

        // Action listener to go to letters panel after clicking continue
        continueButton.addActionListener(e -> cardLayout.show(cardPanel, "letters"));

        // Panel layout for Introduction
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(continueButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add margin around the button panel

        // Add table and continue button to the main panel
        add(tableContainer, BorderLayout.CENTER); // Add centered table container
        add(buttonPanel, BorderLayout.SOUTH); // Button panel at the bottom
    }
}