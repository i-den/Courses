function solve(args) {
    args = args.map(Number);
    let firstNumber = args[0];
    let secondNumber = args[1];

    let result = firstNumber <= secondNumber ? firstNumber * secondNumber : firstNumber / secondNumber;

    console.log(result);
}