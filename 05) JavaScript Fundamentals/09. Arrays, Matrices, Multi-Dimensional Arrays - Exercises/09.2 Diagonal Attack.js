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