function numberString(inputString) {
    let result = '';

    for (let i = 1; i <= Number(inputString); i++) {
        result += i;
    }

    console.log(result);
}