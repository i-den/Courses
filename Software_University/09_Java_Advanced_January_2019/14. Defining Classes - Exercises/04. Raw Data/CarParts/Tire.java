package CarParts;

public class Tire {

    private Integer age;

    private Double pressure;

    public Tire(Integer age, Double pressure) {
        setAge(age);
        setPressure(pressure);
    }

    public Integer getAge() {
        return age;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    public Double getPressure() {
        return pressure;
    }

    private void setPressure(Double pressure) {
        this.pressure = pressure;
    }
}
