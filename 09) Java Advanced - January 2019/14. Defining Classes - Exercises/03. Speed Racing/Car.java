class Car {

    static final String NO_FUEL_ERR_MSG = "Insufficient fuel for the drive";

    private String model;

    private double fuelAmnt;

    private double fuelSpentPer1Km;

    private long totalDistanceTraveled;

    public Car(String model, double fuelAmnt, double fuelSpentPer1Km) {
        setModel(model);
        setFuelAmnt(fuelAmnt);
        setFuelSpentPer1Km(fuelSpentPer1Km);
        setTotalDistanceTraveled(0L);
    }

    boolean hasFuelToDriveDistance(Integer distance) {
        return fuelAmnt - (getFuelSpentPer1Km() * distance)  >= 0;
    }

    void travelDistance(Integer distance) {
        totalDistanceTraveled += distance;
        setFuelAmnt(getFuelAmnt() - (getFuelSpentPer1Km() * distance));
    }

    String getInfo() {
        return String.format("%s %.2f %d", getModel(), getFuelAmnt(), getTotalDistanceTraveled());
    }

    String getModel() {
        return model;
    }

    void setModel(String model) {
        this.model = model;
    }

    double getFuelAmnt() {
        return fuelAmnt;
    }

    void setFuelAmnt(double fuelAmnt) {
        this.fuelAmnt = fuelAmnt;
    }

    double getFuelSpentPer1Km() {
        return fuelSpentPer1Km;
    }

    void setFuelSpentPer1Km(double fuelSpentPer1Km) {
        this.fuelSpentPer1Km = fuelSpentPer1Km;
    }

    long getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }

    void setTotalDistanceTraveled(long totalDistanceTraveled) {
        this.totalDistanceTraveled = totalDistanceTraveled;
    }
}
