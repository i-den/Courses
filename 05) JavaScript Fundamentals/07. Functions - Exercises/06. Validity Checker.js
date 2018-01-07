function validityChecker([firstPtX, firstPtY, secondPtX, secondPtY]) {
    let firstPt = {x: firstPtX, y: firstPtY};
    let secPt = {x: secondPtX, y: secondPtY};
    let ptsArr = [firstPt, secPt];

    for (let i = 0; i < 2; i++) {
        if (getDistanceBtwnPts(ptsArr[i], {x: 0, y: 0}) === Math.round(getDistanceBtwnPts(ptsArr[i], {x: 0, y: 0}))) {
            logResult(ptsArr[i], {x: 0, y: 0}, 'valid');
        } else {
            logResult(ptsArr[i], {x: 0, y: 0}, 'invalid');
        }
    }

    if (getDistanceBtwnPts(firstPt, secPt) === Math.round(getDistanceBtwnPts(firstPt, secPt))) {
        logResult(firstPt, secPt, 'valid');
    } else {
        logResult(firstPt, secPt, 'invalid');
    }

    function getDistanceBtwnPts(firstPt, secPt) {
        let x = Math.pow(firstPt.x - secPt.x, 2);
        let y = Math.pow(firstPt.y - secPt.y, 2);
        return Math.sqrt(x + y);
    }

    function logResult(firstPoint, secondPoint, result) {
        console.log(`{${firstPoint.x}, ${firstPoint.y}} to {${secondPoint.x}, ${secondPoint.y}} is ${result}`);
    }
}