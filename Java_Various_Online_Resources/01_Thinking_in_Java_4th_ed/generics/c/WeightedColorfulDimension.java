package generics.c;

public class WeightedColorfulDimension<T extends Dimension & Weight & Colorful> {

    T weightedColorfulDimension;

    WeightedColorfulDimension(T weightedColorfulDimension) {
        this.weightedColorfulDimension = weightedColorfulDimension;
    }

    T getWeightedColorfulDimension() {
        return this.weightedColorfulDimension;
    }

    Color getColor() {
        return this.weightedColorfulDimension.getColor();
    }

    Integer getX() {
        return weightedColorfulDimension.x;
    }

    Integer getY() {
        return weightedColorfulDimension.y;
    }

    Integer getZ() {
        return weightedColorfulDimension.z;
    }

    Integer getWeight() {
        return this.weightedColorfulDimension.getWeight();
    }

}
