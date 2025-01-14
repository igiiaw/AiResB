class Booking {
    private Passenger passenger;
    private Flight flight;

    public Booking(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void displayBookingDetails() {
        System.out.println("Booking Confirmed:");
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Passenger Age: " + passenger.getAge());
        flight.displayFlightDetails();
    }

    @Override
    public String toString() {
        return "Booking [Passenger=" + passenger.getDetails() + ", Flight=" + flight + "]";
    }
}
