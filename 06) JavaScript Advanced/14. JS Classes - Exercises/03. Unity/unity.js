class Rat {
    constructor(name) {
        this.name = name;
        this.unitedRats = [];
    }

    toString() {
        let thisStr = `${this.name}`;
        for (let rat of this.unitedRats) {
            thisStr += `\n##${rat.name}`
        }
        return thisStr;
    }

    unite(rat) {
        if (rat instanceof Rat) {
            this.unitedRats.push(rat);
        }
    }

    getRats() {
        return this.unitedRats;
    }
}
