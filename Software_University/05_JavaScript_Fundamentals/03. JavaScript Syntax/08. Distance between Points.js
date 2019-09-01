function countDistanceBetweenTwoPoints(firstPointX, firstPointY, secondPointX, secondPointY) {
    let x = Math.pow(firstPointX - secondPointX, 2);
    let y = Math.pow(firstPointY - secondPointY, 2);

    console.log(Math.sqrt(x + y));
}