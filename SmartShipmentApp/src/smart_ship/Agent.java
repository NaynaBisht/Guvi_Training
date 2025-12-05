package smart_ship;

class Agent extends Person {
    private int id;
    private int assignedPackages;

    public Agent(int id, String name, String city) {
        super(name, city);
        this.id = id;
        this.assignedPackages = 0;
    }

    public int getId() { return id; }
    public String getCity() { return city; }
    public int getAssignedPackages() { return assignedPackages; }

    public void assignPackage() { assignedPackages++; }

    @Override
    public void displayDetails() {
        System.out.println("Agent ID: " + id + ", Name: " + name +
                           ", City: " + city + ", Assigned Packages: " + assignedPackages);
    }
}