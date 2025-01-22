import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Flight {
    public static void displayAllFlights() {
        String query = "SELECT * FROM flights";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            System.out.println("\nAvailable Flights:");
            while (resultSet.next()) {
                System.out.printf("%d. %s to %s at %s%n",
                        resultSet.getInt("id"),
                        resultSet.getString("flight_number"),
                        resultSet.getString("destination"),
                        resultSet.getString("departure_time"));
            }
        } catch (Exception e) {
            System.out.println("Error fetching flights: " + e.getMessage());
        }
    }
}