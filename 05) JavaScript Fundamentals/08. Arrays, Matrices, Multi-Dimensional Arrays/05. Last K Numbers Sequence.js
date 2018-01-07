function fibonacciSeq(maxElements, lastElements) {
    let fibArr = [];

    for (let i = 0; i < maxElements; i++) {
        if  (i <= 1) {
            fibArr.push(1);
        } else {
            let sum = 0;
            for (let j = i; j > i - lastElements; j--) {
                if  (j > 0) {
                    sum += fibArr[j - 1];
                }
            }

            fibArr.push(sum)
        }
    }

    console.log(fibArr.join(" "));
}