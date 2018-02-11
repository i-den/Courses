function subSum(array, start, end) {
    if (array.constructor !== Array) {
        return NaN;
    }

    let result = 0;

    start = start < 0
        ? 0
        : start;

    end = end >= array.length
        ? array.length - 1
        : end;

    for (let i = start; i <= end; i++) {
        let currEle = array[i];

        if (typeof currEle !== "number") {
            return NaN;
        }

        result += currEle;
    }

    return result;
}