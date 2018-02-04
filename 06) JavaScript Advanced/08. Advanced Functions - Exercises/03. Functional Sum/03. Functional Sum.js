(function functionalSum() {
    let internalSum = 0;

    function add(value) {
        internalSum += value;
        return add;
    }

    add.toString = () => internalSum;
    return add;
})()
