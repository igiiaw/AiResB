import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/AiResBTb";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "aiiDana20_06";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }
}