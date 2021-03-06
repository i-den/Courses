<h1 align="center"><em>JS Fundamentals - май 2017</em></h1>
 
<br />

 ## *First steps learning JavaScript*
>  ### *Basic Syntax*
 ```JavaScript
function compoundInterest([principal, interestRate, compoundingPeriod, timespan]) {
    [principal, interestRate, compoundingPeriod, timespan] = [principal, interestRate, compoundingPeriod, timespan].map(Number);
    let compoundInterest = principal * Math.pow(1 + interestRate/(100*( 12/compoundingPeriod)), 12/compoundingPeriod * timespan);
    console.log(compoundInterest.toFixed(2));
}


 ```
>  ### *Basic Functions*
 ```JavaScript
function cookingByNumbers(inputArray) {
    let numberToModify = inputArray[0];
    let arrToReturn = [];

    for (let i = 1; i < inputArray.length; i++) {
        switch (inputArray[i]) {
            case "chop":
                numberToModify /= 2;
                break;
            case "dice":
                numberToModify = Math.sqrt(numberToModify);
                break;
            case "spice":
                numberToModify++;
                break;
            case "bake":
                numberToModify *= 3;
                break;
            case "fillet":
                numberToModify *= 0.8;
                break;
        }

        return numberToModify;
    }
}
 ```
>  ### *Arrays, Matrices*
 ```JavaScript
function equalNeighbours(matrix) {
    let equalElements = 0;

    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length - 1; col++) {
            if (matrix[row][col] === matrix[row][col + 1]) {
                equalElements++;
            }
        }
    }

    for (let row = 0; row < matrix.length - 1; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] === matrix[row +1][col]) {
                equalElements++
            }
        }
    }

    return equalElements;
}

function diagonalAttack(inputArr) {
    let matrix = inputArr.map(row => row.split(" ").map(Number));

    let mainSum = 0, secSum = 0;

    for (let i = 0; i < matrix.length; i++) {
        mainSum += matrix[i][i];
        secSum += matrix[i][matrix[i].length - i - 1];
    }

    if (mainSum === secSum) {
        for (let row = 0; row < matrix.length; row++) {
            for (let col = 0; col < matrix.length; col++) {
                if (row === col || (row + col + 1 === matrix.length)) {
                    continue;
                }
                matrix[row][col] = mainSum;
            }
        }
    }

    return matrix.map(row => row.join(" ")).join("\n");
}
 ```

<p align="center">
	<img src="https://camo.githubusercontent.com/2b8ddda21108980f9d59fee3848ac39967207c43/68747470733a2f2f736e6970636172747765622d313066332e6b7863646e2e636f6d2f6d656469612f393930312f70726574656e64696e672d76616e696c6c612d6a6176617363726970742d6b6e6f776c656467652e6a7067" />
</p>
<p align="center">
	<a href="https://softuni.bg/trainings/1649/js-fundamentals-may-2017">Course Page</a> <br />
</p>
