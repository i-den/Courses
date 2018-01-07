function maxIncEle(inputArray) {
    let outputArr = [inputArray.shift()];
    for (let i = 0; i < inputArray.length; i++) {
        if (inputArray[i] >= outputArr[outputArr.length - 1]) {
            outputArr.push(inputArray[i]);
        }
    }

    outputArr.forEach(e => console.log(e));
}