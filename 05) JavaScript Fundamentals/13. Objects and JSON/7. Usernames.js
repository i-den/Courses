function solve(inputArr) {
    let set = new Set();

    for (let name of inputArr) {
        set.add(name);
    }
    let myArr = [...set];

    myArr.sort((a, b) => setFn(a, b)).forEach(e => console.log(e));

    function setFn(a, b) {
        let lenCmp = a.length - b.length;
        if (lenCmp === 0) {
            return a > b;
        }
        return lenCmp;
    }
}

solve([
    'Denise',
    'Ignatius',
    'Iris',
    'Isacc',
    'Indie',
    'Dean',
    'Donatello',
    'Enfuego',
    'Benjamin',
    'Biser',
    'Bounty',
    'Renard',
    'Rot'
]);


