package hotel_management;
import java.util.*;

public class Booking {
	private List<Hotel> hotels;
    private Scanner scanner;

    public Booking() {
        hotels = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeHotels();
    }

    // Hardcode some hotels
    private void initializeHotels() {
        hotels.add(new Hotel("Maharani Resort", "Nainital", 200, 3500));
        hotels.add(new Hotel("HillTop Retreat", "Nainital", 200, 2800));
        hotels.add(new Hotel("LakeView", "Nainital", 200, 2500));
        hotels.add(new Hotel("Royal Hotel", "Nainital", 200, 4000));
    }

    // Display all hotels
    private void displayHotels() {
        System.out.println("\nAvailable Hotels:");
        for (int i = 0; i < hotels.size(); i++) {
            Hotel h = hotels.get(i);
            System.out.println((i + 1) + ". " + h.getName() + " (" + h.getDestination() + ") - ₹" 
                    + h.getPricePerRoom() + " per room | Available: " + h.getAvailableRooms());
        }
    }

    // Method to handle one booking session
    private void bookHotel() {
        displayHotels();
        System.out.print("\nEnter the number of the hotel you want to book: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice < 1 || choice > hotels.size()) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        Hotel selectedHotel = hotels.get(choice - 1);

        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter number of rooms to book: ");
        int roomsToBook = scanner.nextInt();

        boolean success = selectedHotel.bookRoom(roomsToBook);
        if (success) {
            selectedHotel.printInvoice(customerName, roomsToBook);
        }
    }

    // Main menu to keep booking
    public void startBooking() {
        boolean continueBooking = true;

        System.out.println("Hotel Booking System");

        while (continueBooking) {
            bookHotel();

            System.out.print("Do you want to book another room? (yes/no): ");
            String answer = scanner.next().toLowerCase();

            if (!answer.equals("yes")) {
                continueBooking = false;
                System.out.println("Thank you");
            }
        }
    }
}
