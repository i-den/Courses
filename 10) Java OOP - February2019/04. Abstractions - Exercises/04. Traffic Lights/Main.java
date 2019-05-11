import traffic.TrafficLightManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLights = scanner.nextLine().split("\\s+");
        int shuffleCnt = Integer.parseInt(scanner.nextLine());

        TrafficLightManager trafficLightManager = new TrafficLightManager(inputLights);
        for (int i = 0; i < shuffleCnt; i++) {
            System.out.println(trafficLightManager.getTrafficOutput(i));
        }
    }
}