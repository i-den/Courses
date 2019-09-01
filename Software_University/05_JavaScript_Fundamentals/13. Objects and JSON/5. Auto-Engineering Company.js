function solve(inputArr) {
    let cars = new Map();

    for (let carInfo of inputArr) {
        let [brand, model, producedCars] = carInfo.split(/\s*\|\s*/g);
        chkMem(cars, brand, new Map());
        chkMem(cars.get(brand), model, 0);
        cars.get(brand).set(model, cars.get(brand).get(model) + Number(producedCars));
    }

    for (let [brand, sales] of cars) {
        console.log(brand);
        for (let [model, tot] of sales) {
            console.log(`###${model} -> ${tot}`)
        }
    }

    function chkMem(inpMap, entry, prop) {
        if (!inpMap.has(entry)) {
            inpMap.set(entry, prop);
        }
    }
}

console.log(solve([
    'Audi | Q7 | 1000',
    'Audi | Q6 | 100',
    'BMW | X5 | 1000',
    'BMW | X6 | 100',
    'Citroen | C4 | 123',
    'Volga | GAZ-24 | 1000000',
    'Lada | Niva | 1000000',
    'Lada | Jigula | 1000000',
    'Citroen | C4 | 22',
    'Citroen | C5 | 10'
]));