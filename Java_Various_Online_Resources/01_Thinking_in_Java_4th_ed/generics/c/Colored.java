package generics.c;

public class Colored<T extends Colorful> {

    T colorfulType;

    Colored(T colorfulType) {
        this.colorfulType = colorfulType;
    }

    T getColorfulType() {
        return this.colorfulType;
    }

    Color getColorfulTypeColor() {
        return colorfulType.getColor();
    }

}
