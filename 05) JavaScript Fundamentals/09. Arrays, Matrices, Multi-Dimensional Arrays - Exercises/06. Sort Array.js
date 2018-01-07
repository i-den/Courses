function sorterino(inputArray) {
    inputArray.sort(compare).forEach(e => console.log(e));

    function compare(a, b) {
        let lenCmp = a.length - b.length;
        if (lenCmp === 0) {
            return a.localeCompare(b);
        }
        return lenCmp;
    }
}