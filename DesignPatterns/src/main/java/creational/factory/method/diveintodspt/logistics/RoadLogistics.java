package creational.factory.method.diveintodspt.logistics;

import creational.factory.method.diveintodspt.transport.Transport;
import creational.factory.method.diveintodspt.transport.Truck;

public class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
