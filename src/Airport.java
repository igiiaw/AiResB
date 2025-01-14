import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Airport {
    private List<Booking> bookings;

    public Airport() {
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> filterByDestination(String destination) {
        List<Booking> result = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getFlight().getDestination().equalsIgnoreCase(destination)) {
                result.add(booking);
            }
        }
        return result;
    }

    public List<Booking> searchPassenger(String keyword) {
        List<Booking> result = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getPassenger().getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(booking);
            }
        }
        return result;
    }

    public void sortBookingsByFlightNumber() {
        bookings.sort(Comparator.comparing(b -> b.getFlight().getFlightNumber()));
    }

    public void displayBookings() {
        for (Booking booking : bookings) {
            booking.displayBookingDetails();
            System.out.println();
        }
    }
}
