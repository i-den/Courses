import java.util.Scanner;

public class Problem {

    final static private double iniTaxTaxi = 0.7;
    final static private double taxiDayFeeKm = 0.79;
    final static private double taxiNightFeeKm = 0.9;

    final static private byte busMinKm = 20;
    final static private double busFeeKm = 0.09;

    final static private byte trainMinKm = 100;
    final static private double trainFeeKm = 0.06;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double transportFeeTotal;

        int kmToTravel = scanner.nextInt();
        String dayOrNight = scanner.next();

        if (kmToTravel >= trainMinKm) {
            transportFeeTotal = kmToTravel * trainFeeKm;
        } else if (kmToTravel >= busMinKm) {
            transportFeeTotal = kmToTravel * busFeeKm;
        } else if (dayOrNight.toLowerCase().equals("day")){
            transportFeeTotal = iniTaxTaxi + (kmToTravel * taxiDayFeeKm);
        } else {
            transportFeeTotal = iniTaxTaxi + (kmToTravel * taxiNightFeeKm);
        }

        System.out.printf("%.2f", transportFeeTotal);
    }
}