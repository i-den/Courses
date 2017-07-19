function solve(args) {
    args = args[0].split(' ').map(Number);
    let firstNumber = args[0];
    let secondNumber = args[1];
    let thirdNumber = args[2];

    console.log(areSummable(firstNumber, secondNumber, thirdNumber) ||
                areSummable(firstNumber, thirdNumber, secondNumber) ||
                areSummable(secondNumber, thirdNumber, firstNumber) ||
                'No');

    function areSummable(firstNumber, secondNumber, result) {
        if (firstNumber + secondNumber !== result) {
            return false;
        } else {
            if (firstNumber > secondNumber) {
                [firstNumber, secondNumber] = [secondNumber, firstNumber];
            }

            return `${firstNumber} + ${secondNumber} = ${result}`;
        }

    }
}