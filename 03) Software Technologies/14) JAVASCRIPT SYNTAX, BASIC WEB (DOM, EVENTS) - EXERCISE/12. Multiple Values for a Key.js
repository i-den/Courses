function solve(args) {
    args = args.filter(x => x !== "");
    let resultArray = [];
    let keyToPrint = args.pop();
    let result = "";

    for (let i = 0; i < args.length; i++) {
        let currentKey = args[i].split(' ')[0];
        let currentValue = args[i].split(' ')[1];

       if (resultArray[currentKey] === undefined) {
           resultArray[currentKey] = [];
       }

       resultArray[currentKey].push(currentValue);
    }

    if (keyToPrint in resultArray) {
        result = resultArray[keyToPrint];
    } else {
        console.log("None");
        return;
    }

    result.forEach(x => console.log(x));
}