class Point {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }

    static distance(firstPoint, secondPoint) {
        let distanceX = firstPoint.x - secondPoint.x;
        let distanceY = firstPoint.y - secondPoint.y;
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY)
    }
}