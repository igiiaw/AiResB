import java.util.Scanner;

public class AiResB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== AiResB: Airport Booking System ===");
            System.out.println("1. View Available Flights");
            System.out.println("2. Add Booking");
            System.out.println("3. Update Passenger");
            System.out.println("4. Delete Passenger");
            System.out.println("5. Update Booking");
            System.out.println("6. Delete Booking");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> Flight.displayAllFlights();
                case 2 -> addBooking(scanner);
                case 3 -> updatePassenger(scanner);
                case 4 -> deletePassenger(scanner);
                case 5 -> updateBooking(scanner);
                case 6 -> deleteBooking(scanner);
                case 7 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addBooking(Scanner scanner) {
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();
        System.out.print("Enter passenger age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        int passengerId = Passenger.addPassenger(name, age);
        if (passengerId == -1) {
            System.out.println("Failed to add passenger.");
            return;
        }

        System.out.println("\nAvailable Flights:");
        Flight.displayAllFlights();

        System.out.print("Enter flight ID to book: ");
        int flightId = scanner.nextInt();

        Booking.addBooking(passengerId, flightId);
    }

    private static void updatePassenger(Scanner scanner) {
        System.out.print("Enter Passenger ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new age: ");
        int newAge = scanner.nextInt();

        Passenger.updatePassenger(id, newName, newAge);
    }

    private static void deletePassenger(Scanner scanner) {
        System.out.print("Enter Passenger ID to delete: ");
        int id = scanner.nextInt();

        Passenger.deletePassenger(id);
    }

    private static void updateBooking(Scanner scanner) {
        System.out.print("Enter Booking ID to update: ");
        int bookingId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new Passenger ID: ");
        int newPassengerId = scanner.nextInt();
        System.out.print("Enter new Flight ID: ");
        int newFlightId = scanner.nextInt();

        Booking.updateBooking(bookingId, newPassengerId, newFlightId);
    }

    private static void deleteBooking(Scanner scanner) {
        System.out.print("Enter Booking ID to delete: ");
        int bookingId = scanner.nextInt();

        Booking.deleteBooking(bookingId);
    }
}