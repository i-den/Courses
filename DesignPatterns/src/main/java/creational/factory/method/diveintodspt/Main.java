package creational.factory.method.diveintodspt;

import creational.factory.method.diveintodspt.logistics.Logistics;
import creational.factory.method.diveintodspt.logistics.RoadLogistics;
import creational.factory.method.diveintodspt.logistics.SeaLogistics;

public class Main {

    public static void main(String[] args) {
        readConfig();
        Logistics logistics;

        if ("setting" == "sea") {
            logistics = new SeaLogistics();
        } else {
            logistics = new RoadLogistics();
        }

        logistics.planDelivery();
    }

    static void readConfig() {

    };
}
