const lookupChar = require("./lookup-char").lookupChar;
const expect = require("chai").expect;

describe("lookupChar(string, index)", function () {
    describe("normal - valid inputs", function () {
        it("should return r for (String, 2)", function () {
            expect(lookupChar("String", 2)).to.equal('r');
        });
    });

    describe("special - non-valid inputs", function () {
        describe("undefined", function () {
            it("should return undefined with a non-string first argument", function () {
                expect(lookupChar(13, 0)).to.be.undefined;
                expect(lookupChar(NaN, 0)).to.be.undefined;
                expect(lookupChar({}, 0)).to.be.undefined;
                expect(lookupChar([], 0)).to.be.undefined;
                expect(lookupChar(null, 0)).to.be.undefined;
                expect(lookupChar(undefined, 0)).to.be.undefined;
            });

            it("should return undefined with a non-string second argument", function () {
                expect(lookupChar(0, 13)).to.be.undefined;
                expect(lookupChar(0, NaN)).to.be.undefined;
                expect(lookupChar(0, {})).to.be.undefined;
                expect(lookupChar(0, [])).to.be.undefined;
                expect(lookupChar(0, null)).to.be.undefined;
                expect(lookupChar(0, undefined)).to.be.undefined;
            });

            it("should return undefined with a floating point number second argument", function () {
                expect(lookupChar("String", 3.14)).to.be.undefined;
            });
        });

        describe("Incorrect index", function () {
            it("should return Incorrect index for values outside of the string length", function () {
                expect(lookupChar("String", -1)).to.equal("Incorrect index");
                expect(lookupChar("String", "String".length)).to.equal("Incorrect index");
                expect(lookupChar("String", "String".length + 1)).to.equal("Incorrect index");
            });
        });
    });
});