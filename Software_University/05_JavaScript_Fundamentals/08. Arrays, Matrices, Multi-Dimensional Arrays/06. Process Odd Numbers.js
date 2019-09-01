function processOdd(inputArray) {
    return inputArray.filter((e, i) => i % 2 !== 0)
        .map((e) => e * 2)
        .reverse()
        .join(" ");
}