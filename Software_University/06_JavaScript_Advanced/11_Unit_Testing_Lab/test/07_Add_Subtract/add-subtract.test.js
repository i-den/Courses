const createCalculator = require("./add-subtract").createCalculator;
let expect = require("chai").expect;

describe("createCalculator()", function () {
    let calculator;

    beforeEach(function () {
        calculator = createCalculator();
    });

    describe("reflection", function () {
        // Return an Object
        it("should return an object", function () {
            expect(typeof createCalculator()).to.be.equal("object");
        });

        // Add / Subtract / Get functions
        it("should contain an add function", function () {
            expect(typeof createCalculator().add).to.be.equal("function");
        });
        it("should contain an subtract function", function () {
            expect(typeof createCalculator().subtract).to.be.equal("function");
        });
        it("should contain an get function", function () {
            expect(typeof createCalculator().get).to.be.equal("function");
        });

        // Only 3 functions
        it("should have only Add / Subtract / Get functionality", function () {
            expect(Object.keys(createCalculator()).length).to.be.equal(3);
        });
    });

    describe("normal - valid input", function () {
        it("should return 0 for no input", function () {
            expect(calculator.get()).to.equal(0);
        });

        it("should return 0 for changing the value property", function () {
            calculator.value = 1;
            expect(calculator.get()).to.equal(0);
        });

        it("should return 5 for adding 2, 3", function () {
            calculator.add(2);
            calculator.add(3);
            expect(calculator.get()).to.equal(2 + 3);
        });

        it("should return 5 for adding 2 as string, 3", function () {
            calculator.add('2');
            calculator.add(3);
            expect(calculator.get()).to.equal(2 + 3);
        });

        it("should return -5 for subtracting 2, 3", function () {
            calculator.subtract(2);
            calculator.subtract(3);
            expect(calculator.get()).to.equal(- 2 - 3);
        });

        it("should return -5 for subtracting 2 as string, 3", function () {
            calculator.subtract('2');
            calculator.subtract(3);
            expect(calculator.get()).to.equal(- 2 - 3);
        });

        it("should return 0 for adding and subtracting MAX_SAFE_INTEGER", function () {
            calculator.add(Number.MAX_SAFE_INTEGER);
            calculator.subtract(Number.MAX_SAFE_INTEGER);
            expect(calculator.get()).to.equal(0);
        });

        it("should return 18014398509481982 for adding two MAX_SAFE_INTEGER", function () {
            calculator.add(Number.MAX_SAFE_INTEGER);
            calculator.add(Number.MAX_SAFE_INTEGER);
            expect(calculator.get()).to.equal(Number.MAX_SAFE_INTEGER + Number.MAX_SAFE_INTEGER);
        });

        it("should return -18014398509481982 for subtracting two MAX_SAFE_INTEGER", function () {
            calculator.subtract(Number.MAX_SAFE_INTEGER);
            calculator.subtract(Number.MAX_SAFE_INTEGER);
            expect(calculator.get()).to.equal(- Number.MAX_SAFE_INTEGER - Number.MAX_SAFE_INTEGER);
        });
    });

    describe("special - invalid input", function () {
        it("should return NaN for adding a string", function () {
            calculator.add("string");
            expect(calculator.get()).to.be.NaN;
        });
        it("should return NaN for adding an Object", function () {
            calculator.add({});
            expect(calculator.get()).to.be.NaN;
        });

        it("should return NaN for subtracting a string", function () {
            calculator.subtract("string");
            expect(calculator.get()).to.be.NaN;
        });
        it("should return NaN for subtracting an Object", function () {
            calculator.subtract({});
            expect(calculator.get()).to.be.NaN;
        });
    });
});
