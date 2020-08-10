//Problem 1
function isEven(number) {
    return number % 2 === 0;
}

//Problem 2
function factorial(number) {
    let result = 1;

    for(let i = 1; i <= number; i++) {
        result *= i;
    }

    return result;
}

//Problem 3
function kebabToSnake(string) {
    return "\"" + string.replace('-', '_') + "\"";
}