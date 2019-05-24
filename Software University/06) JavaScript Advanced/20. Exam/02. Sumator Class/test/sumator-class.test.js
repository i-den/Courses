const Sumator = require("../sumator").Sumator;
const expect = require("chai").expect;

describe('Sumator tests', function () {
    let smtr;
    beforeEach(() => {
        smtr = new Sumator();
    });

    describe('data tests', function () {
        it('should have a data property', function () {
            expect(smtr.hasOwnProperty("data")).to.be.true;
        });
        it('should have an empty array data property at start', function () {
            expect(smtr.data.length).to.equal(0);
            expect(Array.isArray(smtr.data)).to.be.true;
        });
    });

    describe('add(item) tests', function () {
        it('should add correctly a number', function () {
            smtr.add(1);
            expect(smtr.toString()).to.equal("1");
        });
        it('should add correctly a string', function () {
            smtr.add(2);
            smtr.add("String");
            expect(smtr.toString()).to.equal("2, String");
        });
        it('should add correctly a bool', function () {
            smtr.add(3);
            smtr.add(true);
            smtr.add(false);
            expect(smtr.toString()).to.equal("3, true, false");
        });
        it('should add correctly an object', function () {
            smtr.add({});
            smtr.add({name: "Pesho", age: 24});
            expect(smtr.toString()).to.equal("[object Object], [object Object]")
        });
        it('should add correctly an array', function () {
            smtr.add([4, 5, 6]);
            smtr.add([1, 2, 3]);
            expect(smtr.toString()).to.equal("4,5,6, 1,2,3");
        });
        it('should add correctly numbers, strings, bools, objects, arrays', function () {
            smtr.add(1);
            smtr.add("String");
            smtr.add(true);
            smtr.add({name: "Pesho", age: 24});
            smtr.add([1, 2, 3]);
            expect(smtr.toString()).to.equal("1, String, true, [object Object], 1,2,3");
        });
    });

    describe('sumNums() tests', function () {
        it('should return 0 with empty data', function () {
            expect(smtr.sumNums()).to.equal(0);
        });

        it('should return 0 with no numbers in', function () {
            smtr.add("1");
            smtr.add([]);
            smtr.add({age: 5});
            smtr.add(true);
            smtr.add(Symbol);
            smtr.add(new Date());
            expect(smtr.sumNums()).to.equal(0);
        });

        it('should return 1 with just the number 1 in it', function () {
            smtr.add(1);
            smtr.add("-1");
            expect(smtr.sumNums()).to.equal(1);
        });

        it('should return 0 with 1 and -1 in it', function () {
            smtr.add(1);
            smtr.add(-1);
            expect(smtr.sumNums()).to.equal(0);
        });

        it('should return 3.14 with 1 and 2.14 in it', function () {
            smtr.add(1);
            smtr.add(2.14);
            expect(smtr.sumNums()).to.equal(1 + 2.14);
        });

        it('should return 3.14 with 4.24 and -1.1 in it', function () {
            smtr.add(4.24);
            smtr.add(-1.1);
            expect(smtr.sumNums()).to.equal(4.24 - 1.1);
        });
    });

    describe('removeByFilter(filterFunc) tests', function () {
        it('should return 1, 2, 3 for filtering all numbers above 3', function () {
            smtr.add(1);
            smtr.add(2);
            smtr.add(3);
            smtr.add(4);
            smtr.add(5);
            smtr.add(6);
            smtr.add(7);
            smtr.removeByFilter((x) => x > 3);
            expect(smtr.toString()).to.equal("1, 2, 3");
        });

        it('should return just numbers', function () {
            expect(smtr.toString()).to.equal("(empty)");
            smtr.add("1");
            smtr.add([]);
            smtr.add({age: 5});
            smtr.add(true);
            smtr.add(Symbol);
            smtr.add(new Date());
            smtr.removeByFilter((x) => typeof(x) !== "number");
            expect(smtr.toString()).to.equal("(empty)");
            smtr.add(1);
            expect(smtr.toString()).to.equal("1");
        });
    });

    describe('sample usage', function () {
        it('should be as in the sample', function () {
            expect(`${smtr}`).to.equal("(empty)");
            smtr.add(1);
            smtr.add(2);
            smtr.add("three");
            smtr.add(4);
            expect(`${smtr}`).to.equal("1, 2, three, 4");
            smtr.add("5.5");
            smtr.add(7.7);
            expect(`${smtr}`).to.equal("1, 2, three, 4, 5.5, 7.7");
            smtr.removeByFilter(x => x % 2 === 0);
            expect(`${smtr}`).to.equal("1, three, 5.5, 7.7");
            expect(smtr.sumNums()).to.equal(8.7);
        });

    });
});