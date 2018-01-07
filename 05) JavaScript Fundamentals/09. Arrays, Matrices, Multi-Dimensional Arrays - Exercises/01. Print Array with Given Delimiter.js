function printAnArray(inputArray) {
    let delim = inputArray.pop();

    return inputArray.join(delim);
}