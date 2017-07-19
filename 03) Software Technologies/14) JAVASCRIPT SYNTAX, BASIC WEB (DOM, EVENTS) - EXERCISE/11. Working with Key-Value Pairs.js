function solve(args) {
    args = args.filter(x => x !== "");
    let resultArray = [];
    let keyToPrint = args.pop();
    let result = "";

    for (let i = 0; i < args.length; i++) {
        let currentKey = args[i].split(' ')[0];
        let currentValue = args[i].split(' ')[1];

        resultArray[currentKey] = currentValue;
    }

    if (keyToPrint in resultArray) {
        result = resultArray[keyToPrint];
    } else {
        result = "None";
    }

    console.log(result);
}