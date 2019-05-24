function aggregateElemntz(array) {
    let sum = 0;

    for (let i = 0; i < array.length; i++) {
        sum += 1 / array[i];
    }

    console.log(array.reduce((a, b) => a + b, 0));
    console.log(sum);
    console.log(array.reduce((a, b) => a + '' + b));
}