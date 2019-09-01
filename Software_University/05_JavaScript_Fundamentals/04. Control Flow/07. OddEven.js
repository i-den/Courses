function oddOrEven(inputNumber) {
    if (inputNumber % 2 === 0) {
        console.log('even');
    } else if (inputNumber !== Math.round(inputNumber)) {
        console.log('invalid');
    } else {
        console.log('odd')
    }
}