function orbitDuvki([rows, cols, x, y]) {
    let matrix = [];
    for (let i = 0; i < rows; i++) {
        matrix.push([]);
    }

    for (let row = 0; row < rows; row++) {
        for (let col = 0; col < cols; col++) {
            matrix[row][col] = Math.max(Math.abs(x - row), Math.abs(y - col)) + 1;
        }
    }

    return matrix.map(row => row.join(" ")).join("\n");
}