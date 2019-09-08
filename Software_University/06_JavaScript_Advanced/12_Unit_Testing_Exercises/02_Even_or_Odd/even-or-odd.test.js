const isOddOrEven = require("./even-or-odd").isOddOrEven;
let expect = require("chai").expect;

describe("isOddOrEven(string)", function () {
    describe("normal - valid input", function () {
        it("should return even for EVEN", function () {
            expect(isOddOrEven("EVEN")).to.equal("even");
        });
        it("should return odd for ODD", function () {
            expect(isOddOrEven("ODD")).to.equal("odd");
        });
        it("should return even for an empty string", function () {
            expect(isOddOrEven('')).to.equal("even");
        });
    });

    describe("special - non-valid input", function () {
        it("should return undefined for a number", function () {
            expect(isOddOrEven(1)).to.be.undefined;
        });
        it("should return undefined for an object", function () {
            expect(isOddOrEven({})).to.be.undefined;
        });
    });
});