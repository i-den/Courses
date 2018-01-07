function modifyNum(inputNum) {
    while (getAverageOfDigits(Number(inputNum)) <= 5) {
        inputNum = inputNum.toString().concat("9");
    }

    return inputNum;

    function getAverageOfDigits(numberToGetAvgOf) {
        let sum = 0;

        for (let i = 0; i < numberToGetAvgOf.toString().length; i++) {
            sum += Number(numberToGetAvgOf.toString()[i]);
        }

        return sum / numberToGetAvgOf.toString().length;
    }
}