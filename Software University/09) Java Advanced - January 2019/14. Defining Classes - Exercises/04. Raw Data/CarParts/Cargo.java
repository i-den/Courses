package CarParts;

public class Cargo {

    private Integer weight;

    private String type;

    public Cargo(Integer weight, String type) {
        setWeight(weight);
        setType(type);
    }

    public Integer getWeight() {
        return weight;
    }

    private void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }
}
