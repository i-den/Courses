function solve(args) {
    let myNums = args
        .map(Number)
        .sort((a, b) => b - a);

    let count = Math.min(myNums.length, 3);

    for (let i = 0; i < count; i++) {
        console.log(myNums[i]);
    }
}