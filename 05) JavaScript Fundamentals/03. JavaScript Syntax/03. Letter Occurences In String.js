function countLetter(inputString, inputLetter) {
    let charOccurrences  = 0;

    for (let i = 0; i < inputString.length; i++) {
        if (inputString[i] == inputLetter) {
            charOccurrences++;
        }
    }

    console.log(charOccurrences);
}