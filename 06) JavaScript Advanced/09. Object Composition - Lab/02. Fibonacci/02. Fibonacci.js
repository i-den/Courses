function getFibonator() {
    let firstNum = 0;
    let secNum = 1;

    return () => {
        let thirdNum = firstNum + secNum;
        [firstNum, secNum] = [secNum, thirdNum];
        return firstNum;
    }
}