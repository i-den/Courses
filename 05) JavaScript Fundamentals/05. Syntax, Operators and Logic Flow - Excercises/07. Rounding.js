function rounding([numberToBeRounded, precision]) {
    [numberToBeRounded, precision] = [numberToBeRounded, precision].map(Number);

    precision = precision > 15
        ? 15
        : precision;

    let roundedNumber = Math.round(numberToBeRounded * Math.pow(10, precision)) / Math.pow(10, precision);
    console.log(roundedNumber);
}