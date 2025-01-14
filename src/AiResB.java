import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AiResB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Airport airport = new Airport();
        List<Flight> availableFlights = createFlights();

        while (true) {
            System.out.println("\n=== Airport Booking System ===");
            System.out.println("1. View Available Flights");
            System.out.println("2. Add Booking");
            System.out.println("3. View All Bookings");
            System.out.println("4. Filter by Destination");
            System.out.println("5. Search by Passenger Name");
            System.out.println("6. Sort Bookings by Flight Number");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> viewAvailableFlights(availableFlights);
                case 2 -> addBooking(scanner, airport, availableFlights);
                case 3 -> airport.displayBookings();
                case 4 -> filterByDestination(scanner, airport);
                case 5 -> searchByPassenger(scanner, airport);
                case 6 -> {
                    airport.sortBookingsByFlightNumber();
                    System.out.println("Bookings sorted by flight number.");
                }
                case 7 -> {
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static List<Flight> createFlights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("F101", "New York", 300, "08:00 AM"));
        flights.add(new Flight("F102", "Los Angeles", 400, "10:30 AM"));
        flights.add(new Flight("F103", "Chicago", 200, "01:00 PM"));
        flights.add(new Flight("F104", "San Francisco", 450, "03:45 PM"));
        return flights;
    }

    private static void viewAvailableFlights(List<Flight> flights) {
        System.out.println("\nAvailable Flights:");
        for (Flight flight : flights) {
            flight.displayFlightDetails();
            System.out.println();
        }
    }

    private static void addBooking(Scanner scanner, Airport airport, List<Flight> availableFlights) {
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();

        System.out.print("Enter passenger age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("\nAvailable Flights:");
        for (int i = 0; i < availableFlights.size(); i++) {
            System.out.println((i + 1) + ". " + availableFlights.get(i));
        }

        System.out.print("Choose a flight to book (enter number): ");
        int flightChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (flightChoice < 1 || flightChoice > availableFlights.size()) {
            System.out.println("Invalid flight selection. Booking failed.");
            return;
        }

        Flight chosenFlight = availableFlights.get(flightChoice - 1);
        Passenger passenger = new Passenger(name, age);
        Booking booking = new Booking(passenger, chosenFlight);
        airport.addBooking(booking);

        System.out.println("\nBooking Successful!");
        booking.displayBookingDetails();
    }

    private static void filterByDestination(Scanner scanner, Airport airport) {
        System.out.print("Enter destination to filter: ");
        String destination = scanner.nextLine();

        List<Booking> filtered = airport.filterByDestination(destination);
        if (filtered.isEmpty()) {
            System.out.println("No bookings found for the destination: " + destination);
        } else {
            System.out.println("Filtered Bookings:");
            for (Booking booking : filtered) {
                booking.displayBookingDetails();
                System.out.println();
            }
        }
    }

    private static void searchByPassenger(Scanner scanner, Airport airport) {
        System.out.print("Enter passenger name to search: ");
        String keyword = scanner.nextLine();

        List<Booking> searched = airport.searchPassenger(keyword);
        if (searched.isEmpty()) {
            System.out.println("No bookings found for passenger: " + keyword);
        } else {
            System.out.println("Search Results:");
            for (Booking booking : searched) {
                booking.displayBookingDetails();
                System.out.println();
            }
        }
    }
}
