function treasureLocator(inputArray) {
    let islands = [
        {name: "Tuvalu", xMin: 1, xMax: 3, yMin: 1, yMax: 3},
        {name: "Tokelau", xMin: 8, xMax: 9, yMin: 0, yMax: 1},
        {name: "Samoa", xMin: 5, xMax: 7, yMin: 3, yMax: 6},
        {name: "Tonga", xMin: 0, xMax: 2, yMin: 6, yMax: 8},
        {name: "Cook", xMin: 4, xMax: 9, yMin: 7, yMax: 8}
    ];

    for (let i = 0; i < inputArray.length; i += 2) {
        let currentCoordinates = {x: inputArray[i], y: [inputArray[i + 1]], hasTreasure: false};

        for (let j = 0; j < islands.length; j++) {
            if (checkForTreasure(currentCoordinates, islands[j])) {
                console.log(islands[j].name);
                currentCoordinates.hasTreasure = true;
                break;
            }
        }

        if (!currentCoordinates.hasTreasure) {
            console.log("On the bottom of the ocean");
        }
    }

    function checkForTreasure(coordinates, island) {
        return (coordinates.x >= island.xMin && coordinates.x <= island.xMax
            && coordinates.y >= island.yMin && coordinates.y <= island.yMax);
    }
}