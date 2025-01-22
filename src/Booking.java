import java.sql.Connection;
import java.sql.PreparedStatement;

public class Booking {
    public static void addBooking(int passengerId, int flightId) {
        String query = "INSERT INTO bookings (passenger_id, flight_id) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, passengerId);
            statement.setInt(2, flightId);
            statement.executeUpdate();
            System.out.println("Booking added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding booking: " + e.getMessage());
        }
    }

    public static void updateBooking(int bookingId, int newPassengerId, int newFlightId) {
        String query = "UPDATE bookings SET passenger_id = ?, flight_id = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, newPassengerId);
            statement.setInt(2, newFlightId);
            statement.setInt(3, bookingId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Booking updated successfully.");
            } else {
                System.out.println("No booking found with ID = " + bookingId);
            }
        } catch (Exception e) {
            System.out.println("Error updating booking: " + e.getMessage());
        }
    }

    public static void deleteBooking(int bookingId) {
        String query = "DELETE FROM bookings WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, bookingId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Booking deleted successfully.");
            } else {
                System.out.println("No booking found with ID = " + bookingId);
            }
        } catch (Exception e) {
            System.out.println("Error deleting booking: " + e.getMessage());
        }
    }
}