import java.util.Objects;

class Flight {
    private String flightNumber;
    private String destination;
    private int duration;
    private String departureTime;

    public Flight(String flightNumber, String destination, int duration, String departureTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.duration = duration;
        this.departureTime = departureTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public int getDuration() {
        return duration;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void displayFlightDetails() {
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Destination: " + destination);
        System.out.println("Duration: " + duration + " mins");
        System.out.println("Departure Time: " + departureTime);
    }

    @Override
    public String toString() {
        return "Flight [FlightNumber=" + flightNumber + ", Destination=" + destination +
                ", Duration=" + duration + " mins, DepartureTime=" + departureTime + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Flight flight = (Flight) obj;
        return duration == flight.duration &&
                Objects.equals(flightNumber, flight.flightNumber) &&
                Objects.equals(destination, flight.destination) &&
                Objects.equals(departureTime, flight.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, destination, duration, departureTime);
    }
}
