function diagonalSum(inputArrays) {

    let mainDiagSum = 0;
    for (let i = 0; i < inputArrays.length; i++) {
        mainDiagSum += inputArrays[i][i];
    }

    let secDiagSum = 0;
    for (let i = inputArrays.length - 1; i >= 0; i--) {
        secDiagSum += inputArrays[inputArrays.length - i - 1][i];
    }

    return [mainDiagSum, secDiagSum].join(" ");
}