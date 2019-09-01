function rotateArr(inputArray) {
    let rotationCount = inputArray.pop() % inputArray.length;

    for (let i = 0; i < rotationCount; i++) {
        inputArray = [inputArray.pop()].concat(inputArray)
    }

    return inputArray.join(" ");
}
