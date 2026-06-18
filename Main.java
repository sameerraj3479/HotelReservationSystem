import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hotel hotel = new Hotel();

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("    HOTEL RESERVATION SYSTEM");
            System.out.println("==================================");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    hotel.showRooms();
                    break;

                case 2:

                    System.out.print("\nEnter Room Number : ");
                    int roomNo = sc.nextInt();

                    sc.nextLine(); // Clear Buffer

                    System.out.print("Enter Customer Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone Number : ");
                    String phone = sc.nextLine();

                    hotel.bookRoom(roomNo, name, phone);

                    break;

                case 3:

                    System.out.print("\nEnter Reservation ID : ");
                    int id = sc.nextInt();

                    hotel.cancelBooking(id);

                    break;

                case 4:

                    hotel.viewBookings();

                    break;

                case 5:

                    System.out.println("\nThank You For Using Hotel Reservation System.");
                    System.out.println("Visit Again!");

                    break;

                default:

                    System.out.println("\nInvalid Choice!");

            }

        } while (choice != 5);

        sc.close();

    }

}