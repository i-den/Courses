function solve(args) {
    let result = [];

    for (let i = 0; i < args.length; i++) {
        let currentCommandParameters = args[i].split(' ');

        switch  (currentCommandParameters[0]) {
            case "add":
                result.push(currentCommandParameters[1]);
                break;
            case "remove":
                let currIndiceToRemove = Number(currentCommandParameters[1]);

                if (currIndiceToRemove < result.length && currIndiceToRemove >= 0) {
                    result.splice(currIndiceToRemove, 1);
                }
        }
    }

    result.forEach(x => console.log(x));
}