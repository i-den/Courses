function gradsToDegrees(inputGrads) {
    let degrees = inputGrads * 0.9;

    if (degrees > 0) {
        console.log(degrees % 360);
    } else {
        let negativeDegrees = degrees % 360;
        console.log(360 + negativeDegrees);
    }
}