function sortArr(inputArray) {
    let array = inputArray.filter(a => a < 0).reverse().concat(inputArray.filter(a => a >= 0));
    for (let i = 0; i < inputArray.length; i++) {
        console.log(array[i])
    }
}