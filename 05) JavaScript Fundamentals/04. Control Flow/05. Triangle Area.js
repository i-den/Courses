function triangleArea(firstSide, secondSide, thirdSide) {
    let semiPerimeter = (firstSide + secondSide + thirdSide) / 2;

    return Math.sqrt(semiPerimeter * (semiPerimeter - firstSide) * (semiPerimeter - secondSide) * (semiPerimeter - thirdSide))
}