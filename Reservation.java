public class Reservation {

    private int reservationId;
    private Customer customer;
    private Room room;
    private String status;

    public Reservation(int reservationId, Customer customer, Room room, String status) {

        this.reservationId = reservationId;
        this.customer = customer;
        this.room = room;
        this.status = status;

    }

    public int getReservationId() {
        return reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {

        return "\nReservation ID : " + reservationId +
                "\nCustomer : " + customer.getName() +
                "\nPhone : " + customer.getPhone() +
                "\nRoom : " + room.getRoomNumber() +
                "\nType : " + room.getRoomType() +
                "\nPrice : Rs. " + room.getPrice() +
                "\nStatus : " + status;

    }

}