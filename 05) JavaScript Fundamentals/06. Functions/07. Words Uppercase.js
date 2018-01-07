function wordsUpper(inputString) {
    let regEx = /[^\W]+/g;
    let wordArr = [];
    let m;

    while (m = regEx.exec(inputString)) {
        wordArr.push(m[0].toUpperCase());
    }

    console.log(wordArr.join(", "));
}