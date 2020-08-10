package creational.factory.method.diveintodspt.logistics;

import creational.factory.method.diveintodspt.transport.Ship;
import creational.factory.method.diveintodspt.transport.Transport;

public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
