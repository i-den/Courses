package creational.factory.method.diveintodspt.transport;

public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Ship.deliver()");
    }
}
