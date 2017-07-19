function solve(args) {
    args = args.map(Number);
    let negativeNumbersCount = 0;
    let zeroFound = args.filter(x => x === 0).length > 0;
    let result = "";

    negativeNumbersCount = args
        .filter(x => x < 0)
        .length;

    if (negativeNumbersCount % 2 !== 0 && !zeroFound) {
        result = "Negative";
    } else {
        result = "Positive";
    }

    console.log(result);
}