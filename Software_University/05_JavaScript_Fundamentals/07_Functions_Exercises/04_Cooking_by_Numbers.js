function cookingByNumbers(inputArray) {
    let numberToModify = inputArray[0];
    let arrToReturn = [];

    for (let i = 1; i < inputArray.length; i++) {
        switch (inputArray[i]) {
            case "chop":
                numberToModify /= 2;
                break;
            case "dice":
                numberToModify = Math.sqrt(numberToModify);
                break;
            case "spice":
                numberToModify++;
                break;
            case "bake":
                numberToModify *= 3;
                break;
            case "fillet":
                numberToModify *= 0.8;
                break;
        }

        console.log(numberToModify);
    }
}