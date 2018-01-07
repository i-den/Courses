function sum(inputArray) {
    let sum = 0;

    for (let num of inputArray) {
        sum += num;
    }

    console.log(`sum = ${sum}`);
    console.log(`vat = ${sum * 0.2}`);
    console.log(`total = ${sum * 1.2}`);
}