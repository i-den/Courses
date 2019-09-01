import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> availCars = new ArrayList(Arrays.asList(scanner.nextLine().split("\\s+")));
        int iniCarAmnt = availCars.size();

        while (true) {
            String[] saleTkns = scanner.nextLine().split("\\s+");

            if (saleTkns[0].equals("End")) {
                break;
            }

            int seats = Integer.parseInt(saleTkns[2]);
            String car = saleTkns[0].substring(0, 1).toLowerCase();
            String carReq = car + seats;

            int carIndex = availCars.indexOf(carReq);

            if (carIndex >= 0) {
                availCars.remove(carIndex);
                System.out.printf("Yes, sold for %d$%n", (int) car.charAt(0) * seats);
            } else {
                System.out.println("No");
            }
        }

        System.out.printf("Vehicles left: %s%n", String.join(", ", availCars));
        System.out.printf("Vehicles sold: %d%n", iniCarAmnt - availCars.size());
    }
}