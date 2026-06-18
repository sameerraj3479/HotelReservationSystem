import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;
    private int reservationCounter = 1001;

    public Hotel() {

        rooms = new ArrayList<>();
        reservations = new ArrayList<>();

        loadRooms();
    }

    // Load Rooms
    private void loadRooms() {

        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Standard", 1500));

        rooms.add(new Room(201, "Deluxe", 3000));
        rooms.add(new Room(202, "Deluxe", 3000));

        rooms.add(new Room(301, "Suite", 5000));
        rooms.add(new Room(302, "Suite", 5000));
    }

    // Show All Rooms
    public void showRooms() {

        System.out.println("\n========== AVAILABLE ROOMS ==========");

        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    // Search Room
    public Room searchRoom(int roomNumber) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }

        return null;
    }

    // Book Room
    public void bookRoom(int roomNumber, String name, String phone) {

        Room room = searchRoom(roomNumber);

        if (room == null) {
            System.out.println("\nRoom Not Found!");
            return;
        }

        if (!room.isAvailable()) {
            System.out.println("\nRoom Already Booked!");
            return;
        }

        Customer customer = new Customer(name, phone);

        Reservation reservation = new Reservation(
                reservationCounter++,
                customer,
                room,
                "Confirmed"
        );
        // OTP Verification
        if (OTP.verifyOTP()) {

            Payment payment = new Payment();

            if (payment.makePayment(room.getPrice())) {

                reservations.add(reservation);

                room.setAvailable(false);

                FileManager.saveBooking(reservation);

                System.out.println("\nBooking Confirmed!");
                System.out.println(reservation);
            }

        } else {

            System.out.println("Booking Failed! OTP Verification Unsuccessful.");

        }

        // Payment
        Payment payment = new Payment();

        if (payment.makePayment(room.getPrice())) {

            reservations.add(reservation);

            room.setAvailable(false);

            // Save Booking in File
            FileManager.saveBooking(reservation);

            System.out.println("\nBooking Confirmed!");
            System.out.println(reservation);
        }
    }

    // Cancel Booking
    public void cancelBooking(int reservationId) {

        for (int i = 0; i < reservations.size(); i++) {

            Reservation reservation = reservations.get(i);

            if (reservation.getReservationId() == reservationId) {

                reservation.getRoom().setAvailable(true);

                reservations.remove(i);

                System.out.println("\nBooking Cancelled Successfully.");

                return;
            }
        }

        System.out.println("\nReservation Not Found.");
    }

    // View All Bookings
    public void viewBookings() {

        if (reservations.isEmpty()) {

            System.out.println("\nNo Bookings Found.");
            return;
        }

        System.out.println("\n========== BOOKING DETAILS ==========");

        for (Reservation reservation : reservations) {

            System.out.println(reservation);
            System.out.println("----------------------------------------");
        }
    }
}