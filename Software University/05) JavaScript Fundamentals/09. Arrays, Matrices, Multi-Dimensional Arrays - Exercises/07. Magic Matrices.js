function magicMatrices(matrix) {
    matrix = matrix.map(row => row.map(num => Number(num)));
    let sum = matrix[0].reduce((a, b) => a + b);

    for (let i = 1; i < matrix.length; i++) {
        if (sum !== matrix[i].reduce((a, b) => a + b)) {
            return false;
        }
    }

    for (let col = 0; col < matrix.length; col++) {
        let colSum = 0;
        for (let row = 0; row < matrix[col].length; row++) {
            colSum += matrix[row][col];
        }

        if (colSum !== sum) {
            return false;
        }
    }

    return true;
}