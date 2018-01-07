function triangleOfStars(inputNumber) {

    printTriangleTop(inputNumber);
    printTriangleBottom(inputNumber);

    function printTriangleTop(inputNumber) {
        for (let i = 1; i <= inputNumber; i++) {
            console.log("*".repeat(i));
        }
    }

    function printTriangleBottom(inputNumber) {
        for (let i = inputNumber - 1; i > 0; i--) {
            console.log("*".repeat(i));
        }
    }
}