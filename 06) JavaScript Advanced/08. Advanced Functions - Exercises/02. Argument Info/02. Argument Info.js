function solve() {
    let argsCount = new Map();

    for (let i = 0; i < arguments.length; i++) {
        let obj = arguments[i];
        let type = typeof obj;
        console.log(type + ': ' + obj);

        if (!argsCount.has(type)) {
            argsCount.set(type, 0);
        }

        argsCount.set(type, argsCount.get(type) + 1);
    }

    Array.from(argsCount).sort((firstArr, secArr) => {
        return secArr[1] - firstArr[1];
    }).forEach(([key, val]) => {
        console.log(`${key} = ${val}`)
    });
}

solve(42, 'cat', 15, 'kitten', 'tomcat');