function distance3D(inputArray) {
    let firstPointX = inputArray[0];
    let firstPointY = inputArray[1];
    let firstPointZ = inputArray[2];

    let secondPointX = inputArray[3];
    let secondPointY = inputArray[4];
    let secondPointZ = inputArray[5];

    let distance = Math.sqrt(Math.pow(firstPointX - secondPointX, 2) + Math.pow(firstPointY - secondPointY, 2) + Math.pow(firstPointZ - secondPointZ, 2));

    console.log(distance);
}