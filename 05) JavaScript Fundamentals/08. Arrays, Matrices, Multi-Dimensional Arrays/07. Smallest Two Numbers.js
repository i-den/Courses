function smallestTwo(inputArray) {
    return inputArray.sort((a, b) => a - b)
        .slice(0, 2)
        .join(" ");
}