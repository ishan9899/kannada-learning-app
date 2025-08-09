import java.sql.*;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/kannada_learning";
    private static final String USER = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "12345"; // Replace with your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Fetch letters from the database
    public static ResultSet getLetters() throws SQLException {
        Connection conn = getConnection();
        String query = "SELECT * FROM letters";
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    // Fetch Swaragalu (Vowels) from the database
    public static ResultSet getVowels() throws SQLException {
        Connection conn = getConnection();
        String query = "SELECT letter_image, english_phonetic FROM letters WHERE group_type = 'Swaragalu'";
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    // Fetch Yogavahagalu (Partly vowel and partly consonant) from the database
    public static ResultSet getYogavahagalu() throws SQLException {
        Connection conn = getConnection();
        String query = "SELECT letter_image, english_phonetic FROM letters WHERE group_type = 'Yogavahagalu'";
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }


    // Fetch words (assuming you have a separate table for words)
    public static ResultSet getWords() throws SQLException {
        Connection conn = getConnection();
        String query = "SELECT * FROM words";
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }
}
