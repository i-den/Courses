import java.util.ArrayDeque;
import java.util.Scanner;

public class TruckTour {

    private static ArrayDeque<PetrolStation> petrolStations;
    private static long petrolStationsCnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        petrolStations = new ArrayDeque<>();
        petrolStationsCnt = scanner.nextLong();

        for (int i = 0; i < petrolStationsCnt; i++) {
            petrolStations.add(new PetrolStation(scanner.nextLong(), scanner.nextLong()));
        }

        for (int i = 0; i < petrolStationsCnt; i++) {
            if (stationIsValidStartingPoint()) {
                System.out.println(i);
                break;
            }

            petrolStations.add(petrolStations.pollLast());
        }
    }

    private static boolean stationIsValidStartingPoint() {
        long currFuel = 0;
        boolean stationFound = true;

        for (int i = 0; i < petrolStationsCnt; i++) {
            PetrolStation currStation = petrolStations.remove();

            currFuel += currStation.getCurrRefuelAmt() - currStation.getFuelUntilNextStation();

            if (currFuel < 0) {
                stationFound = false;
                break;
            }

            petrolStations.add(currStation);
        }

        return stationFound;
    }
}

class PetrolStation {

    private long currRefuelAmt;
    private long fuelUntilNextStation;

    PetrolStation(long currRefuelAmt, long fuelUntilNextStation) {
        this.setCurrRefuelAmt(currRefuelAmt);
        this.setFuelUntilNextStation(fuelUntilNextStation);
    }

    long getCurrRefuelAmt() {
        return currRefuelAmt;
    }

    private void setCurrRefuelAmt(long currRefuelAmt) {
        this.currRefuelAmt = currRefuelAmt;
    }

    long getFuelUntilNextStation() {
        return fuelUntilNextStation;
    }

    private void setFuelUntilNextStation(long fuelUntilNextStation) {
        this.fuelUntilNextStation = fuelUntilNextStation;
    }
}