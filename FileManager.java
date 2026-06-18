import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private static final String FILE_NAME = "bookings.txt";

    public static void saveBooking(Reservation reservation) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));

            writer.write("====================================");
            writer.newLine();

            writer.write("Reservation ID : " + reservation.getReservationId());
            writer.newLine();

            writer.write("Customer Name : " + reservation.getCustomer().getName());
            writer.newLine();

            writer.write("Phone : " + reservation.getCustomer().getPhone());
            writer.newLine();

            writer.write("Room Number : " + reservation.getRoom().getRoomNumber());
            writer.newLine();

            writer.write("Room Type : " + reservation.getRoom().getRoomType());
            writer.newLine();

            writer.write("Price : Rs. " + reservation.getRoom().getPrice());
            writer.newLine();

            writer.write("Status : " + reservation.getStatus());
            writer.newLine();

            writer.write("====================================");
            writer.newLine();
            writer.newLine();

            writer.close();

        } catch (IOException e) {

            System.out.println("Error Saving Booking!");

        }

    }

}