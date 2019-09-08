function figureArea(firstWidth, firstHeight, secondWidth, secondHeight) {

    let [firstArea, secondArea, intersection] = [
        firstWidth * firstHeight,
        secondWidth * secondHeight,
        Math.min(firstWidth, secondWidth) * Math.min(firstHeight, secondHeight)
    ];

    console.log(firstArea + secondArea - intersection);
}