package carloan;

public class CarDetails {
    String model;
    String variant;
    double price;
    String color;

    // Constructor to initialize the car object
    public CarDetails(String model, String variant, double price, String color) {
        this.model = model;
        this.variant = variant;
        this.price = price;
        this.color = color;
    }

    // Method to display car details
    public void displayCarDetails() {
        System.out.println("Car Details");
        System.out.println("Model: " + this.model);
        System.out.println("Variant: " + this.variant);
        System.out.println("Color: " + this.color);
        System.out.println("Ex-Showroom Price: ₹"+ this.price);
        System.out.println();
    }

}
