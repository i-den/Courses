function pointInRectangle([pointX, pointY, rectMinX, rectMaxX, rectMinY, rectMaxY]) {
    if (pointX >= rectMinX && pointX <= rectMaxX
        && pointY >= rectMinY && pointY <= rectMaxY) {
        console.log("inside");
    } else {
        console.log("outside");
    }
}