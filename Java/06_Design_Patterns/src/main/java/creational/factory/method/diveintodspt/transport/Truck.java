package creational.factory.method.diveintodspt.transport;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Truck.deliver()");
    }
}
