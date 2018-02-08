function result() {
    let innerArray = [];

    function add(element) {
        innerArray.push(element);
        reArrange();
    }

    function remove(index) {
        if (!isIndexValid(index)) {
            return;
        }

        innerArray.splice(index, 1);
        reArrange();
    }

    function get(index) {
        if (!isIndexValid(index)) {
            return;
        }

        return innerArray[index];
    }

    function getSize() {
        return innerArray.length;
    }

    function reArrange() {
        innerArray = innerArray.sort((a, b) => a - b);
    }

    function isIndexValid(index) {
        return index >= 0 && index < innerArray.length
    }

    let obj = {
        add,
        remove,
        get
    };

    Object.defineProperty(obj, "size", {
        get: getSize
    });

    return obj;
}