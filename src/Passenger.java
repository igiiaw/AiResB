class Passenger extends Person {
    public Passenger(String name, int age) {
        super(name, age);
    }

    @Override
    public String getDetails() {
        return "Passenger [Name=" + getName() + ", Age=" + getAge() + "]";
    }
}
