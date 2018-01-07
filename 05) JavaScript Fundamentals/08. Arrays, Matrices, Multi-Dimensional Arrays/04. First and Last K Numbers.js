function firstLast(inputArray) {
    let num = Number(inputArray.shift());

    console.log(inputArray.slice(0, num).join(" "));
    console.log(inputArray.slice(inputArray.length - num, inputArray.length).join(" "));
}