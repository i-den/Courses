class SortedList {
    constructor() {
        this.innerArray = [];
        this.size = this.innerArray.length;
    }

    add(element) {
        this.innerArray.push(element);
        this.reSort();
    }

    remove(index) {
        if (!this.validateIndex(index)) {
            throw new RangeError("Index outside of the bounds of the array")
        }
        this.innerArray.splice(index, 1);
        this.reSort();
    }

    get(index) {
        if (!this.validateIndex(index)) {
            throw new RangeError("Index outside of the bounds of the array")
        }
        return this.innerArray[index];
    }

    validateIndex(index) {
        return index >= 0 && index < this.innerArray.length;
    }

    reSort() {
        this.innerArray.sort((a, b) => a - b);
    }

    get size() {
        return this.innerArray.length;
    }
}

