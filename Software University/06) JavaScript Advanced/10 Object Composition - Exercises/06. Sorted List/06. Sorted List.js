function result(){
    let array = [];

    function getSize() {
        return array.length;
    }

    function add(element) {
        array.push(element);
        sort();
    }

    function remove(index) {
        if (!isIndexValid(index)) {
            return;
        }
        array.splice(index, 1);
        sort();
    }

    function get(index) {
        if (!isIndexValid(index)) {
            return;
        }
        return array[index];
    }

    function sort() {
        array = array.sort((a, b) => (a - b));
    }

    function isIndexValid(index) {
        return index >= 0 && index < array.length;
    }

    let obj = {
        add,
        remove,
        get,

    };

    Object.defineProperty(obj, "size", {
        get: getSize
    });

    return obj;
}