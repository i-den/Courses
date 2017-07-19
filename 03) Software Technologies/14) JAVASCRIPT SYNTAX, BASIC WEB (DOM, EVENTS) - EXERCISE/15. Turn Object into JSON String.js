function solve(args) {
    args = args.filter(x => x !== "");
    let resultObj = {};

    for (let i = 0; i < args.length; i++) {
        let currProp = args[i].split(' -> ')[0];
        let currValue = args[i].split(' -> ')[1];

        if (!isNaN(currValue)) {
            currValue = parseFloat(currValue);
        }

        resultObj[currProp] = currValue;
    }
    console.log(JSON.stringify(resultObj));
}