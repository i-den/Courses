function biggestElement(inputArrays) {
    let maxVals = [];

    for (let currEle of inputArrays) {
        maxVals.push(getMaxElement(currEle));
    }

    return getMaxElement(maxVals);

    function getMaxElement(array) {
        return array.reduce((a, b) => Math.max(a, b));
    }
}