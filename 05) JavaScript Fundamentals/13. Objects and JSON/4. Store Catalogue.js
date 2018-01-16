function storeCatalogue(inputArr) {
    let map = new Map();

    for (let product of inputArr) {
        let firstChar = product.toLowerCase()[0];

        if (!map.has(firstChar)) {
            map.set(firstChar, []);
        }

        map.get(firstChar).push(product);
    }

    for (let [char, arr] of Arrafunction storeCatalogue(inputArr) {
        let map = new Map();

        for (let product of inputArr) {
            let firstChar = product.toLowerCase()[0];

            if (!map.has(firstChar)) {
                map.set(firstChar, []);
            }

            map.get(firstChar).push(product);
        }

        for (let [char, arr] of Array.from(map.entries()).sort()) {
            console.log(char.toUpperCase());
            for (let e of arr.sort()) {
                console.log(e);
            }
        }
    }

    console.log(storeCatalogue([
        'Appricot : 20.4',
        'Fridge : 1500',
        'TV : 1499',
        'Deodorant : 10',
        'Boiler : 300',
        'Apple : 1.25',
        'Anti-Bug Spray : 15',
        'T-Shirt : 10'
    ]));y.from(map.entries()).sort()) {
        console.log(char.toUpperCase());
        for (let e of arr.sort()) {
            console.log(e);
        }
    }
}