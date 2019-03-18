import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {

    private static final String ADD_CAR = "IN";
    private static final String REMOVE_CAR = "OUT";
    private static final String STR_TO_END_INPUT = "END";
    private static final String PARKING_LOT_EMPTY_MSG = "Parking Lot is Empty";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> carsInParkingLot = new HashSet<>();

        String input;
        while (!STR_TO_END_INPUT.equals((input = scanner.nextLine()))) {
            String[] cmdTokens = input.split("[\\s,]+");

            switch (cmdTokens[0]) {
                case ADD_CAR:
                    carsInParkingLot.add(cmdTokens[1]);
                    break;
                case REMOVE_CAR:
                default:
                    carsInParkingLot.remove(cmdTokens[1]);
                    break;
            }
        }

        if (carsInParkingLot.isEmpty()) {
            System.out.println(PARKING_LOT_EMPTY_MSG);
        } else {
            System.out.println(String.join(System.lineSeparator(), carsInParkingLot));
        }
    }
}