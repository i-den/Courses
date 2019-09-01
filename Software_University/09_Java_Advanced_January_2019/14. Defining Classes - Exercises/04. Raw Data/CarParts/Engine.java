package CarParts;

public class Engine {

    private Integer speed;

    private Integer power;

    public Engine(Integer speed, Integer power) {
        setSpeed(speed);
        setPower(power);
    }

    public Integer getSpeed() {
        return speed;
    }

    private void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getPower() {
        return power;
    }

    private void setPower(Integer power) {
        this.power = power;
    }
}
