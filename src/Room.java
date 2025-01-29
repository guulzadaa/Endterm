import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    // Fields
    private int roomNumber;
    private String roomType; // "1bed", "2bed", "lux"
    private double price;
    private boolean isAvailable;
    private LocalDate availableDate;

    // Constructor
    public Room(int roomNumber, String roomType, double price, boolean isAvailable, LocalDate availableDate) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = isAvailable;
        this.availableDate = availableDate;
    }

    // Getters and setters
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }

    // Method for booking a room
    public boolean bookRoom(LocalDate bookingDate) {
        if (isAvailable && (availableDate == null || !bookingDate.isBefore(availableDate))) {
            isAvailable = false;
            availableDate = bookingDate.plusDays(1); // The room will become available the next day
            System.out.println("Room " + roomNumber + " successfully booked for " + bookingDate);
            return true;
        } else {
            System.out.println("Room " + roomNumber + " is not available for " + bookingDate);
            return false;
        }
    }

    // Method to display room information
    public void displayRoomInfo() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        if (!isAvailable) {
            System.out.println("Available From: " + availableDate);
        }
        System.out.println("--------------------------------");
    }
}