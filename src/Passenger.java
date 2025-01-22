import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Passenger {
    public static int addPassenger(String name, int age) {
        String query = "INSERT INTO passengers (name, age) VALUES (?, ?) RETURNING id";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                System.out.println("Passenger added: ID = " + id);
                return id;
            }
        } catch (Exception e) {
            System.out.println("Error adding passenger: " + e.getMessage());
        }
        return -1;
    }

    public static void updatePassenger(int id, String newName, int newAge) {
        String query = "UPDATE passengers SET name = ?, age = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newName);
            statement.setInt(2, newAge);
            statement.setInt(3, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Passenger updated successfully.");
            } else {
                System.out.println("No passenger found with ID = " + id);
            }
        } catch (Exception e) {
            System.out.println("Error updating passenger: " + e.getMessage());
        }
    }

    public static void deletePassenger(int id) {
        String query = "DELETE FROM passengers WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Passenger deleted successfully.");
            } else {
                System.out.println("No passenger found with ID = " + id);
            }
        } catch (Exception e) {
            System.out.println("Error deleting passenger: " + e.getMessage());
        }
    }
}