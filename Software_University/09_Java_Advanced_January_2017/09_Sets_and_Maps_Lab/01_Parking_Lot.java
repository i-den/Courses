import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> cars = new HashSet<>();

        while (true) {
            String[] input = scanner.nextLine()
            .split("(\\s+|,)+");

            if (input[0].equals("END")) {
                break;
            }

            if (input[0].equals("IN")) {
                cars.add(input[1]);
            } else {
                cars.remove(input[1]);
            }
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}