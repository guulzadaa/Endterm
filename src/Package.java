public class Package {
    private String name;
    private double price;
    private String[] services;

    // Constructor
    public Package(String name, double price, String[] services) {
        this.name = name;
        this.price = price;
        this.services = services;
    }

    // Method to display package information
    public void displayInfo() {
        System.out.println("Package: " + name);
        System.out.printf("Price per night: $%.2f\n", price);
        System.out.println("Included Services:");
        for (String service : services) {
            System.out.println("  - " + service);
        }
    }

    public static void main(String[] args) {
        // Creating instances for Bronze, Silver, and Gold hotel packages
        Package bronzePackage = new Package(
                "Bronze",
                5000,
                new String[] {
                        "Standard room",
                        "Free Wi-Fi",
                        "Complimentary breakfast"
                }
        );

        Package silverPackage = new Package(
                "Silver",
                8000,
                new String[] {
                        "Deluxe room",
                        "Free Wi-Fi",
                        "Complimentary breakfast",
                        "Access to the fitness center",
                        "Late check-out (2 PM)"
                }
        );

        Package goldPackage = new Package(
                "Gold",
                10000,
                new String[] {
                        "Suite room",
                        "Free Wi-Fi",
                        "Complimentary breakfast",
                        "Access to the fitness center",
                        "Late check-out (4 PM)",
                        "Personal concierge service",
                        "Airport shuttle service"
                }
        );

        // Displaying package information
        System.out.println("Available Hotel Packages:\n");
        bronzePackage.displayInfo();
        System.out.println("\n---\n");
        silverPackage.displayInfo();
        System.out.println("\n---\n");
        goldPackage.displayInfo();
    }
}
