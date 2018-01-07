function spiralMatrix(rows, cols) {
    let matrix = [];

    for (let i = 0; i < rows; i++) {
        matrix.push([]);
    }

    let currRow = 0, currCol = 0, endRow = rows - 1, endCol = cols - 1, number = 1;

    while (currRow <= endRow || currCol <= endCol) {

        for (let i = currCol; i <= endCol; i++) {
            matrix[currRow][i] = number++;
        }

        for (let i = currRow + 1; i <= endRow; i++) {
            matrix[i][endCol] = number++;
        }

        for (let i = endCol - 1; i >= currCol; i--) {
            matrix[endRow][i] = number++;
        }

        for (let i = endRow - 1; i > currRow; i--) {
            matrix[i][currCol] = number++;
        }

        currRow++;
        endRow--;
        currCol++;
        endCol--;
    }

    console.log(matrix.map(row => row.join(" ")).join("\n"))
}