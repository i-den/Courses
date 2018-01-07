function printNthEle(inputArray) {
    inputArray.filter((e, i) => i % Number(inputArray[inputArray.length - 1]) === 0 && i !== Number(inputArray.length - 1))
        .forEach((e) => console.log(e));
}