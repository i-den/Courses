package generics.c;

/**
 * Extends a Class first, then Interfaces
 */
public class ColoredDimension<T extends Dimension & Colorful> {

    T coloredDimension;

    ColoredDimension(T coloredDimension) {
        this.coloredDimension = coloredDimension;
    }

    T get() {
        return this.coloredDimension;
    }

    Color getColor() {
        return coloredDimension.getColor();
    }

    Integer getX() {
        return coloredDimension.x;
    }

    Integer getY() {
        return coloredDimension.y;
    }

    Integer getZ() {
        return coloredDimension.z;
    }
}
