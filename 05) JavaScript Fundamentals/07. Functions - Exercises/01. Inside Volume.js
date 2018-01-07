function insideVolume(inputArray) {
    for (let i = 0; i < inputArray.length; i += 3) {
        let x = inputArray[i];
        let y = inputArray[i + 1];
        let z = inputArray[i + 2];

        if (x >= 10 && x <= 50
            && y >= 20 && y <= 80
            && z >= 15 && z <= 50) {
            console.log('inside');
        } else {
            console.log('outside');
        }
    }
}