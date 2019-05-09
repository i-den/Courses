package figures;

public class Rectangle {

    private Point topLeftPt;

    private Point bottomRightPt;

    public Rectangle(Point topLeftPt, Point bottomRightPt) {
        setTopLeftPt(topLeftPt);
        setBottomRightPt(bottomRightPt);
    }

    public boolean contains(Point ptToCheck) {
        return (ptToCheck.getX() >= topLeftPt.getX() && ptToCheck.getX() <= bottomRightPt.getX())
                && (ptToCheck.getY() >= bottomRightPt.getY() && ptToCheck.getY() <= topLeftPt.getY());
    }

    public Point getTopLeftPt() {
        return topLeftPt;
    }

    public void setTopLeftPt(Point topLeftPt) {
        this.topLeftPt = topLeftPt;
    }

    public Point getBottomRightPt() {
        return bottomRightPt;
    }

    public void setBottomRightPt(Point bottomRightPt) {
        this.bottomRightPt = bottomRightPt;
    }
}
