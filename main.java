import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connesso a SQLite.");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table'");

                System.out.println("Tabelle nel DB:");
                while (rs.next()) {
                    System.out.println("- " + rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Errore connessione DB: " + e.getMessage());
        }
    }
}
