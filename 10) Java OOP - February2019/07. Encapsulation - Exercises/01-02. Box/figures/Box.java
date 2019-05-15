package figures;

public class Box {

    private double length;

    private double width;

    private double height;

    public Box(double length, double width, double height) throws Exception {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double calculateSurfaceArea() {
        return (2 * length * width) + (2 * length * height) + (2 * width * height);
    }

    public double calculateLateralSurfaceArea() {
        return (2 * length * height) + (2 * width * height);
    }

    public double calculateVolume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return String.format(
                "Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f",
                calculateSurfaceArea(),
                calculateLateralSurfaceArea(),
                calculateVolume()
        );
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) throws Exception {
        if (length < 0) {
            throw new Exception("Length cannot be zero or negative");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) throws Exception {
        if (width < 0) {
            throw new Exception("Width cannot be zero or negative");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws Exception {
        if (height < 0) {
            throw new Exception("Height cannot be zero or negative");
        }
        this.height = height;
    }
}
