function orderRectangles(inputRectangles) {
    let rectangleObjs = [];

    for (let [width, height] of inputRectangles) {
        let rectangle = {
            width: width,
            height: height,
            area: () => rectangle.width * rectangle.height,
            compareTo: (other) => {
                return other.area() - rectangle.area()
                || other.width - rectangle.width
            }
        };

        rectangleObjs.push(rectangle);
    }

    return rectangleObjs.sort((a, b) => a.compareTo(b));
}

orderRectangles([[10,5], [3,20], [5,12]]);