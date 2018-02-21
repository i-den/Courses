<h1 align="center"><em>JS Fundamentals - май 2017</em></h1>
 
<br />

 ## *One step forward and two back learning JavaScript*
>  ### *Basic DOM Manipulation*
 ```JavaScript
function toggle() {
        let button = document.getElementsByClassName("button")[0];
        let text = document.getElementById("extra");
        let btnTxt = '';

        if (button.textContent === 'More') {
            text.style.display = "block";
            btnTxt = 'Less'
        } else {
            text.style.display = "none";
            btnTxt = 'More';
        }

        button.textContent = btnTxt;
    }


 ```
>  ### *Basic jQuery*
 ```JavaScript
function domSearch(silektyr, caseSens) {
    // Define container
    let container = $(silektyr);
    container.addClass("items-control");

    // Adding DIV
    let addControls = $(`<div class="add-controls"></div>`);
    let inputLabel = $(`<label>Enter text: </label>`);
    let inputField = $(`<input>`);
    let addAnchor = $(`<a class="button" style="display: inline-block">Add</a>`);

    inputLabel.append(inputField);
    addControls.append(inputLabel);
    addControls.append(addAnchor);

    // Search DIV
    let searchControls = $(`<div class="search-controls"></div>`);
    let searchLabel = $(`<label>Search: </label>`);
    let searchField = $(`<input>`);

    searchLabel.append(searchField);
    searchControls.append(searchLabel);

    // Results DIV
    let resultControls = $(`<div class="result-controls"></div>`);
    let resultList = $(`<ul class="items-list"></ul>`);

    resultControls.append(resultList);

    // Attach everything to the container
    container.append(addControls);
    container.append(searchControls);
    container.append(resultControls);

    // Adding functionality
    addAnchor.click(function (event) {
        // No empty strings
        if (inputField.val() === '') {
            return;
        }

        let newLi = $(`<li class="list-item"></li>`);
        let delAnchor = $(`<a class="button">X</a>`);
        let newEle = $(`<strong>${inputField.val()}</strong>`);

        newLi.append(delAnchor);
        newLi.append(newEle);

        resultList.append(newLi);

        // Deleting functionality
        delAnchor.click(function () {
            newLi.remove();
        })
    });


    searchField.change(function (event) {
        let pattern = '^' + $(this).val() + '$';

        let regex = caseSens
            ? new RegExp(pattern, "i")
            : new RegExp(pattern);

        $(".list-item").filter(function () {
            if (regex.test(($(this).text().substring(1)))) {
                $(this).show();
            } else {
                $(this).hide();
            }
        })
    });
}


 ```
>  ### *Functions*
 ```JavaScript
(() => {
    let add = (vec1, vec2) => [vec1[0] + vec2[0], vec1[1] + vec2[1]];
    let multiply = (vec1, scalar) => [vec1[0] * scalar, vec1[1] * scalar];
    let length = (vec1) => Math.sqrt(Math.pow(vec1[0], 2) + Math.pow(vec1[1], 2));
    let dot = (vec1, vec2) => vec1[0] * vec2[0] + vec1[1] * vec2[1];
    let cross = (vec1, vec2) => vec1[0] * vec2[1] - vec1[1] * vec2[0];

    return {
        add,
        multiply,
        length,
        dot,
        cross
    }
})();
 ```
 >  ### *Object Composition*
 ```JavaScript
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
 ```
  >  ### *Basic Classes*
 ```JavaScript
class Stringer {
    constructor(initialString, initialLength) {
        this.innerString = initialString;
        this.innerLength = initialLength;
    }

    increase(length) {
        this.innerLength += Number(length);
    }

    decrease(length) {
        this.innerLength -= Number(length);
        this.innerLength = this.innerLength < 0
            ? 0
            : this.innerLength;
    }

    toString() {
        if (this.innerString.length > this.innerLength) {
            return this.innerString.substr(0, this.innerLength) + "...";
        }

        return this.innerString;
    }
}
 ```
  >  ### *Prototype Chain*
 ```JavaScript
function theElemelons() {
    class Melon {
        constructor(weight, melonSort) {
            if (new.target === Melon) {
                throw new Error("Cannot instantiate the Melon Class directly");
            }

            this.weight = weight;
            this.melonSort = melonSort;
        }

        get elementIndex() {
            return this.weight * this.melonSort.length;
        }

        toString() {
            let str = `Sort: ${this.melonSort}\n`;
            str += `Element Index: ${this.elementIndex}`;
            return str;
        }
    }

    class Watermelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = "Water";
        }

        toString() {
            let str = `Element: ${this.element}\n`;
            str += super.toString();
            return str;
        }
    }

    class Firemelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = "Fire";
        }

        toString() {
            let str = `Element: ${this.element}\n`;
            str += super.toString();
            return str;
        }
    }

    class Earthmelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = "Earth";
        }

        toString() {
            let str = `Element: ${this.element}\n`;
            str += super.toString();
            return str;
        }
    }

    class Airmelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = "Air";
        }

        toString() {
            let str = `Element: ${this.element}\n`;
            str += super.toString();
            return str;
        }
    }

    class Melolemonmelon extends Watermelon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
        }

        morph(){
            if(this.element === "Water"){
                this.element = "Fire";
            } else if (this.element === "Fire"){
                this.element = "Earth";
            } else if(this.element === "Earth"){
                this.element = "Air";
            } else {
                this.element = "Water";
            }
        }
    }

    return {
        Melon,
        Watermelon,
        Firemelon,
        Earthmelon,
        Airmelon,
        Melolemonmelon
    }
}
 ```
<p align="center">
	<img src="https://camo.githubusercontent.com/72d4f0fa751acf6dce1dcc312dae2ae4a1125ffd/68747470733a2f2f692e70696e696d672e636f6d2f373336782f66362f34362f61362f66363436613635613636393030616336326361386636333565356135326432332d2d6170702d646576656c6f706d656e742d6a6176617363726970742e6a7067" />
</p>
<p align="center">
	<a href="https://softuni.bg/trainings/1650/js-advanced-july-2017">Course Page</a> <br />
</p>
