function aggregate(inputArray) {
    let sum = reduceFunc(inputArray, (a, b) => a + b);
    let min = reduceFunc(inputArray, (a, b) => Math.min(a, b), Number.MAX_VALUE);
    let max = reduceFunc(inputArray, (a, b) => Math.max(a, b), Number.MIN_VALUE);
    let product = reduceFunc(inputArray, (a, b) => a * b, 1);
    let join = reduceFunc(inputArray, (a, b) => a.toString() + b.toString(), '');

    let c;

    function reduceFunc(arr, func, start = 0) {
        let result = func(start, arr[0]);

        for (let ele of inputArray.slice(1)) {
            result = func(result, ele);
        }
        return result;
    }

    console.log(`Sum = ${sum}`);
    console.log(`Min = ${min}`);
    console.log(`Max = ${max}`);
    console.log(`Product = ${product}`);
    console.log(`Join = ${join}`);
}

aggregate([2,3,10,5]);