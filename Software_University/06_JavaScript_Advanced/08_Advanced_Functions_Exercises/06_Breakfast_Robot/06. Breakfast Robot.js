function solve() {
    let availableIngredients = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0
    };

    function restock([microelement, quantity]) {
        availableIngredients[microelement] += Number(quantity);
        return "Success";
    }

    function prepare([recipe, quantity]) {
        quantity = Number(quantity);

        let recipes = {
            apple: makeProduct(false, 1, false, 2),
            coke: makeProduct(false, 10, false, 20),
            burger: makeProduct(false, 5, 7, 3),
            omelet: makeProduct(5, false, 1, 1),
            cheverme: makeProduct(10, 10, 10, 10)
        };

        let currProduct = recipes[recipe];

        return verifyProduct(
            currProduct,
            currProduct["protein"],
            currProduct["carbohydrate"],
            currProduct["fat"],
            currProduct["flavour"]
        );

        function verifyProduct(product, needsProtein, needsCarbs, needsFats, needsFlavours) {
            let hasMicroMsg = '';

            if (needsProtein) {
                if (!checkAvailability("protein")) {
                    return hasMicroMsg;
                }
            }

            if (needsCarbs) {
                if (!checkAvailability("carbohydrate")) {
                    return hasMicroMsg;
                }
            }

            if (needsFats) {
                if (!checkAvailability("fat")) {
                    return hasMicroMsg;
                }
            }

            if (needsFlavours) {
                if (!checkAvailability("flavour")) {
                    return hasMicroMsg;
                }
            }

            if (needsProtein) {
                availableIngredients["protein"] -= product["protein"] * quantity;
            }

            if (needsCarbs) {
                availableIngredients["carbohydrate"] -= product["carbohydrate"] * quantity;
            }

            if (needsFats) {
                availableIngredients["fat"] -= product["fat"] * quantity;
            }

            if (needsFlavours) {
                availableIngredients["flavour"] -= product["flavour"] * quantity;
            }

            return "Success";

            function checkAvailability (ingredient) {
                if (availableIngredients[ingredient] < product[ingredient] * quantity) {
                    hasMicroMsg = `Error: not enough ${ingredient} in stock`;
                    return false;
                }
                return true;
            }
        }

        function makeProduct(protein, carbohydrate, fats, flavour) {
            return {
                protein: protein,
                carbohydrate: carbohydrate,
                fat: fats,
                flavour: flavour
            }
        }
    }

    function report() {
        return `protein=${availableIngredients["protein"]} carbohydrate=${availableIngredients["carbohydrate"]} fat=${availableIngredients["fat"]} flavour=${availableIngredients["flavour"]}`
    }

    return function (command) {
        let tokens = command.split(' ');
        let action = tokens.shift();
        let res = '';

        switch (action) {
            case "restock":
                res =  restock(tokens);
                return res;
            case "prepare":
                res =   prepare(tokens);
                return res;
            case "report":
                res =   report();
                return res;
        }
    }
}