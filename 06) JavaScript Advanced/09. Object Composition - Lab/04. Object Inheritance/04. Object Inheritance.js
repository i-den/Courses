function solve(inputCommands) {
    let carManager = (function () {
        let cars = new Map();

        let create = ([name, inherits, parent]) => {
            parent = parent
                ? cars.get(parent)
                : null;
            let newCar = Object.create(parent);
            cars.set(name, newCar);
        };

        let set = ([name, key, value]) => {
            let car = cars.get(name);
            car[key] =  value;
        };

        let print = ([name]) => {
            let object = cars.get(name);
            let objProps = [];
            for (let prop in object) {
                objProps.push(`${prop}:${object[prop]}`);
            }
            console.log(objProps.join(", "));
        };

        return {
          create,
          set,
          print
        }
    })();

    for (let command of inputCommands) {
        let cmdTokens = command.split(' ');
        let cmd = cmdTokens.shift();
        carManager[cmd](cmdTokens);
    }
}