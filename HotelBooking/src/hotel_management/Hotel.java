package hotel_management;

public class Hotel {
	private String name;
    private String destination;
    private int totalRooms;
    private int availableRooms;
    private double pricePerRoom;

    public Hotel(String name, String destination, int totalRooms, double pricePerRoom) {
        this.name = name;
        this.destination = destination;
        this.totalRooms = totalRooms;
        this.availableRooms = totalRooms;
        this.pricePerRoom = pricePerRoom;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public double getPricePerRoom() {
        return pricePerRoom;
    }

    // Method to book rooms
    public boolean bookRoom(int count) {
        if (count <= 0) {
            System.out.println("Invalid room count. Please enter a positive number.");
            return false;
        }

        if (availableRooms >= count) {
            availableRooms -= count;
            System.out.println(count + " room(s) booked successfully in " + name );
            return true;
        } else {
            System.out.println("Not enough rooms available. Only " + availableRooms + " left.");
            return false;
        }
    }

    // Method to print invoice
    public void printInvoice(String customerName, int roomCount) {
        double totalCost = roomCount * pricePerRoom;
        System.out.println("\n--------- INVOICE ---------");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Hotel: " + name);
        System.out.println("Destination: " + destination);
        System.out.println("Rooms Booked: " + roomCount);
        System.out.println("Price per Room: ₹" + pricePerRoom);
        System.out.println("Total Amount: ₹" + totalCost);
    }
}
