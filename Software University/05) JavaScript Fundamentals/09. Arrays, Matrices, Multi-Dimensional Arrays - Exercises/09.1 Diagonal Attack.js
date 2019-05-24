function diagonalAttack(inputArr) {
    let matrix = [];
    for (let e of inputArr) {
        matrix.push(e.split(" ").map(Number));
    }

    let mainDiagSum = getDiagSum(matrix, "main");
    let secDiagSum = getDiagSum(matrix, "secondary");

    if (mainDiagSum === secDiagSum) {
        matrix = transformMatrix(matrix, mainDiagSum);
        return matrix.map(row => row.join(" ")).join("\n");
    }

    return matrix.map(row => row.join(" ")).join("\n");

    function getDiagSum(inputMatrix, diagonal) {
        let sum = 0;

        switch (diagonal) {
            case "main":
                for (let i = 0; i < inputMatrix.length; i++) {
                    sum += inputMatrix[i][i];
                }
                break;
            case "secondary":
                for (let i = inputMatrix.length - 1; i >= 0; i--) {
                    sum += inputMatrix[inputMatrix.length - 1 - i][i];
                }
        }

        return sum;
    }

    function transformMatrix(inputMatrix, goldenHammer) {
        let lastRow = 0;
        let lastCol = inputMatrix[0].length - 1;
        for (let row = 0; row < inputMatrix.length; row++) {
            for (let col = 0; col < inputMatrix[row].length; col++) {
                if (row === col || (row === lastRow && col === lastCol)) {
                    continue;
                }
                matrix[row][col] = goldenHammer;
            }
            lastRow++;
            lastCol--;
        }
        return inputMatrix;
    }
}