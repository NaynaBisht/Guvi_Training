package smart_ship;

abstract class Person {
    protected String name;
    protected String city;

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public abstract void displayDetails();
}
