function juice(inputArray) {
    let juices = new Map();
    let bottles = new Map();

    for (let juiceInfo of inputArray) {
        let [juice, quantity] = juiceInfo.split(' => ');

        checkMember(juices, juice);
        juices.set(juice, juices.get(juice) + Number(quantity));

        if (juices.get(juice) >= 1000) {
            checkMember(bottles, juice);
            let amountOfBottles = Math.round(juices.get(juice) / 1000);
            bottles.set(juice, bottles.get(juice) + amountOfBottles);
            juices.set(juice, juices.get(juice) - amountOfBottles * 1000);
        }
    }

    for (let [juiceName, bottle] of bottles) {
        console.log(`${juiceName} => ${bottle}`);
    }

    function checkMember(map, entry) {
        if (!map.has(entry)) {
            map.set(entry, 0);
        }
    }
}