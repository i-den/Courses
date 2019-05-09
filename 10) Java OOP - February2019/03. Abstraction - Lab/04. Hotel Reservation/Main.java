import hotel.ReservationManager;

public class Main {

    public static void main(String[] args) {
        ReservationManager reservationManager = new ReservationManager();
        reservationManager.getReservationInfoFromInput();
        System.out.printf("%.2f", reservationManager.getReservationPrice());
    }
}
