package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A12_Minimum_Platforms {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numCases; i++) {
            input.readLine();
            int[] arrivals = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] departures = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(mapsPlatforms(arrivals, departures));
        }
    }

    private static int mapsPlatforms(int[] arrivals, int[] departures) {
        int currTrainsAtStation = 1;
        int maxTrainsAtOnce = 1;
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int arrivalPtr = 1;
        int departurePtr = 0;

        while (arrivalPtr < arrivals.length) {
            int arrival = arrivals[arrivalPtr];
            int departure = departures[departurePtr];

            if (arrival <= departure) {
                arrivalPtr++;
                currTrainsAtStation++;
                maxTrainsAtOnce = Math.max(maxTrainsAtOnce, currTrainsAtStation);
            }

            if (arrival > departure) {
                departurePtr++;
                currTrainsAtStation--;
            }
        }
        return maxTrainsAtOnce;
    }

    private static int bruteForceMinPlatforms(int[] arrivals, int[] departures) {
        int minPlatforms = 1;

        for (int i = 1; i < arrivals.length; i++) {
            int arrival = arrivals[i];
            int departure = departures[i];
            int currMaxTrains = 1;
            for (int j = 0; j < i; j++) {
                int prevArrival = arrivals[j];
                int prevDeparture = departures[j];

                if ((arrival >= prevArrival && arrival <= prevDeparture) ||
                        (departure >= prevArrival && departure <= prevDeparture)) {
                    currMaxTrains++;
                }
            }
            minPlatforms = Math.max(minPlatforms, currMaxTrains);
        }
        return minPlatforms;
    }
}
