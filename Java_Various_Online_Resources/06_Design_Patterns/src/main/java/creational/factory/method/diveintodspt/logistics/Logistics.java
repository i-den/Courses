package creational.factory.method.diveintodspt.logistics;

import creational.factory.method.diveintodspt.transport.Transport;

public abstract class Logistics {

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }

    protected abstract Transport createTransport();
}
