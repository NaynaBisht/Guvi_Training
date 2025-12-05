package smart_ship;

public class PackageDetails {
	private int packageId;
    private String destinationCity;
    private int priority; // 1 = High, 2 = Medium, 3 = Low

    public PackageDetails(int packageId, String destinationCity, int priority) {
        this.packageId = packageId;
        this.destinationCity = destinationCity;
        this.priority = priority;
    }

    public int getPackageId() { return packageId; }
    public String getDestinationCity() { return destinationCity; }
    public int getPriority() { return priority; }

    @Override
    public String toString() {
        return "Package ID: " + packageId +
               ", Destination: " + destinationCity +
               ", Priority: " + priority;
    }

}
