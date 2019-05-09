package hotel;

import java.util.Scanner;

public class ReservationManager {

    private PriceCalculator priceCalculator;

    private Scanner scanner;

    private double pricePerDay;
    private int numberOfDays;
    private String season;
    private String discountType;

    public ReservationManager() {
        priceCalculator = new PriceCalculator();
        scanner = new Scanner(System.in);
    }

    public void getReservationInfoFromInput() {
        String[] tokens = scanner.nextLine().split("\\s+");
        pricePerDay = Double.parseDouble(tokens[0]);
        numberOfDays = Integer.parseInt(tokens[1]);
        season = tokens[2];
        discountType = tokens[3];
    }

    public double getReservationPrice() {
        return priceCalculator.calculate(pricePerDay, numberOfDays, season, discountType);
    }
}
