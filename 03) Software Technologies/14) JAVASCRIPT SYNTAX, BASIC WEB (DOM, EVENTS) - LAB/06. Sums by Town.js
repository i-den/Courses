function solve(args) {
    let result = [];

    for (let i = 0; i < args.length; i++) {
        let jsonFormat = JSON.parse(args[i]);
        let currTown = jsonFormat['town'];
        let currIncome = Number(jsonFormat['income']);

        if (result[currTown] !== undefined) {
            result[currTown] += currIncome
        } else {
            result[currTown] = currIncome;
        }
    }

    let towns = Object
        .keys(result)
        .sort();

    for (let obj of towns) {
        let currTown = obj;
        let currTotalIncome = result[currTown];

        console.log(`${currTown} -> ${currTotalIncome}`);
    }
}