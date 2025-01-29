import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserController userController = new UserController();

        System.out.println("Welcome to the Hotel Booking System!");

        // === 1. Регистрация пользователя ===
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your phone number (10 digits): ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        User newUser = new User(name, surname, email, password, number);
        userController.registerUser(newUser);

        System.out.println("\nUser registered successfully!\n");

        // === 2. Выбор гостиничного пакета ===
        System.out.println("Available Hotel Packages:\n");

        Package bronzePackage = new Package(
                "Bronze", 5000,
                new String[]{"Standard room", "Free Wi-Fi", "Complimentary breakfast"}
        );

        Package silverPackage = new Package(
                "Silver", 8000,
                new String[]{"Deluxe room", "Free Wi-Fi", "Complimentary breakfast", "Access to the fitness center", "Late check-out (2 PM)"}
        );

        Package goldPackage = new Package(
                "Gold", 10000,
                new String[]{"Suite room", "Free Wi-Fi", "Complimentary breakfast", "Access to the fitness center", "Late check-out (4 PM)", "Personal concierge service", "Airport shuttle service"}
        );

        bronzePackage.displayInfo();
        System.out.println("\n---\n");
        silverPackage.displayInfo();
        System.out.println("\n---\n");
        goldPackage.displayInfo();
        System.out.println("\n");

        System.out.print("Select your package (Bronze/Silver/Gold): ");
        String packageChoice = scanner.nextLine().trim().toLowerCase();

        Package selectedPackage;
        switch (packageChoice) {
            case "silver":
                selectedPackage = silverPackage;
                break;
            case "gold":
                selectedPackage = goldPackage;
                break;
            default:
                selectedPackage = bronzePackage;
        }

        System.out.println("\nYou selected the " + selectedPackage.getName() + " package.\n");

        // === 3. Бронирование номера ===
        Room room = new Room(101, "Deluxe", selectedPackage.getPrice(), true, LocalDate.now());

        System.out.print("Enter the booking date (YYYY-MM-DD): ");
        String bookingDateInput = scanner.nextLine();
        LocalDate bookingDate = LocalDate.parse(bookingDateInput);

        boolean bookingSuccess = room.bookRoom(bookingDate);
        if (bookingSuccess) {
            System.out.println("Booking successful!");
        } else {
            System.out.println("Sorry, the room is not available.");
        }

        scanner.close();
    }
}
