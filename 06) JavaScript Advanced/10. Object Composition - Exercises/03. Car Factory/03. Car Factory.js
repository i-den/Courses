function carFactory(carObj) {
    let carAdjuster = (function () {
        let smallEngine = {
            power: 90,
            volume: 1800
        };

        let normalEngine = {
            power: 120,
            volume: 2400
        };

        let monsterEngine = {
            power: 200,
            volume: 3500
        };

        let hatchback = {
            type: "hatchback",
            color: ''
        };

        let coupe = {
            type: "coupe",
            color: ''
        };

        function addEngine(carToAdjust) {
            if (carToAdjust.power <= 90) {
                carToAdjust.engine = smallEngine;
            } else if (carToAdjust.power <= 120) {
                carToAdjust.engine = normalEngine;
            } else {
                carToAdjust.engine = monsterEngine;
            }
        }

        function addCarriage(carToAdjust) {
            switch (carToAdjust.carriage) {
                case "hatchback":
                    hatchback.color = carToAdjust.color;
                    carToAdjust.carriage = hatchback;
                    break;
                case "coupe":
                    coupe.color = carToAdjust.color;
                    carToAdjust.carriage = coupe;
                    break;
            }
        }

        function adjustWheels(carToAdjust) {
            let number = carToAdjust.wheelsize % 2 === 0
                ? carToAdjust.wheelsize - 1
                : carToAdjust.wheelsize;

            carToAdjust.wheels = [number, number, number, number];
        }

        function clearLeftovers(carToAdjust) {
            delete carToAdjust.power;
            delete carToAdjust.color;
            delete carToAdjust.wheelsize;
        }

        return {
            addEngine,
            addCarriage,
            adjustWheels,
            clearLeftovers
        }
    })();

    carAdjuster.addEngine(carObj);
    carAdjuster.addCarriage(carObj);
    carAdjuster.adjustWheels(carObj);
    carAdjuster.clearLeftovers(carObj);

    return carObj;
}