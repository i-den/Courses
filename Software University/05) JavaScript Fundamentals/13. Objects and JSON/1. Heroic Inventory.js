function solve(inputArr) {
    let heroes = [];

    for (let heroInfo of inputArr) {
        let [name, level, weapons] = heroInfo.split(/\s*\/\s*/g);
        weapons = weapons.split(', ');

        heroes.push({name: name, level: Number(level), weapons: weapons});
    }

    return JSON.stringify(heroes);
}

console.log(solve([
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
]));