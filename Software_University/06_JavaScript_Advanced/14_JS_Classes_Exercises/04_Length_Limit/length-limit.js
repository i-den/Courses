class Stringer {
    constructor(initialString, initialLength) {
        this.innerString = initialString;
        this.innerLength = initialLength;
    }

    increase(length) {
        this.innerLength += Number(length);
    }

    decrease(length) {
        this.innerLength -= Number(length);
        this.innerLength = this.innerLength < 0
            ? 0
            : this.innerLength;
    }

    toString() {
        if (this.innerString.length > this.innerLength) {
            return this.innerString.substr(0, this.innerLength) + "...";
        }

        return this.innerString;
    }
}