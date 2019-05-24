const mathEnforcer = require("./math-enforcer").mathEnforcer;
const expect = require("chai").expect;

describe("mathEnforcer", function () {
    describe("addFive(num)", function () {
        describe("normal - valid input", function () {
            it("should return 5 with 0 as argument", function () {
                expect(mathEnforcer.addFive(0)).to.equal(5);
            });
            it("should return 0 with -5 as argument", function () {
                expect(mathEnforcer.addFive(-5)).to.equal(-5 + 5);
            });
            it("should return 8.14 with 3.14 as argument", function () {
                expect(mathEnforcer.addFive(3.14)).to.equal(3.14 + 5);
            });
            it("should return 1.8599999999999999 ;) with -3.14 as argument", function () {
                expect(mathEnforcer.addFive(-3.14)).to.equal(-3.14 + 5);
            });
            it("should return 9007199254740996 with Number.MAX_SAFE_INTEGER as argument", function () {
                expect(mathEnforcer.addFive(Number.MAX_SAFE_INTEGER)).to.equal(Number.MAX_SAFE_INTEGER + 5);
            });
        });
        describe("special - non-valid input", function () {
            it("should return undefined for non-number argument", function () {
                expect(mathEnforcer.addFive("")).to.be.undefined;
                expect(mathEnforcer.addFive("String")).to.be.undefined;
                expect(mathEnforcer.addFive("0")).to.be.undefined;
                expect(mathEnforcer.addFive("9007199254740986")).to.be.undefined;
                expect(mathEnforcer.addFive([])).to.be.undefined;
                expect(mathEnforcer.addFive({})).to.be.undefined;
                expect(mathEnforcer.addFive(new Date())).to.be.undefined;
                expect(mathEnforcer.addFive(true)).to.be.undefined;
                expect(mathEnforcer.addFive(null)).to.be.undefined;
                expect(mathEnforcer.addFive(undefined)).to.be.undefined;
                expect(mathEnforcer.addFive(Symbol)).to.be.undefined;
                expect(mathEnforcer.addFive()).to.be.undefined;
            });
        });
    });
    describe("subtractTen(num)", function () {
        describe("normal - valid input", function () {
            it("should return 0 for 10 as argument", function () {
                expect(mathEnforcer.subtractTen(10)).to.equal(0);
            });
            it("should return -10 for 0 as argument", function () {
                expect(mathEnforcer.subtractTen(0)).to.equal(-10);
            });
            it("should return -13 for 0 as argument", function () {
                expect(mathEnforcer.subtractTen(-3)).to.equal(-13);
            });
            it("should return approx 3.14 for 13.14 as argument", function () {
                expect(mathEnforcer.subtractTen(13.14)).to.be.closeTo(3.14, 0.01);
            });
            it("should return approx -3.14 for 6.86 as argument", function () {
                expect(mathEnforcer.subtractTen(6.86)).to.be.closeTo(-3.14, 0.01);
            });
        });
        describe("special - non-valid input", function () {
            it("should return undefined for non-number argument", function () {
                expect(mathEnforcer.subtractTen("")).to.be.undefined;
                expect(mathEnforcer.subtractTen("String")).to.be.undefined;
                expect(mathEnforcer.subtractTen("0")).to.be.undefined;
                expect(mathEnforcer.subtractTen("9007199254740991")).to.be.undefined;
                expect(mathEnforcer.subtractTen([])).to.be.undefined;
                expect(mathEnforcer.subtractTen({})).to.be.undefined;
                expect(mathEnforcer.subtractTen(new Date())).to.be.undefined;
                expect(mathEnforcer.subtractTen(true)).to.be.undefined;
                expect(mathEnforcer.subtractTen(null)).to.be.undefined;
                expect(mathEnforcer.subtractTen(undefined)).to.be.undefined;
                expect(mathEnforcer.subtractTen(Symbol)).to.be.undefined;
                expect(mathEnforcer.subtractTen()).to.be.undefined;
            });
        });
    });
    describe("sum(num1, num2)", function () {
        describe("normal - valid input", function () {
            it("should return a valid sum for Integers as input", function () {
                expect(mathEnforcer.sum(0, 10)).to.equal(10, "(0, 10) => 10");
                expect(mathEnforcer.sum(10, 0)).to.equal(10, "(10, 0) => 10");
                expect(mathEnforcer.sum(Number.MAX_SAFE_INTEGER, Number.MAX_SAFE_INTEGER)).to.equal(Number.MAX_SAFE_INTEGER + Number.MAX_SAFE_INTEGER, "(Number.MAX_SAFE_INTEGER, Number.MAX_SAFE_INTEGER) => 18014398509481982");
            });
            it("should return a valid sum for Floating point numbers", function () {
                expect(mathEnforcer.sum(0, 3.14)).to.equal(3.14, "(0, 3.14) => 3.14");
                expect(mathEnforcer.sum(3.14, 0)).to.equal(3.14, "(3.14, 0) => 3.14");
            });
        });
        describe("special - non-valid input", function () {
            it("should return undefined for non-valid first argument", function () {
                expect(mathEnforcer.sum("", 1)).to.be.undefined;
                expect(mathEnforcer.sum("String", 1)).to.be.undefined;
                expect(mathEnforcer.sum("5", 1)).to.be.undefined;
                expect(mathEnforcer.sum([], 1)).to.be.undefined;
                expect(mathEnforcer.sum({}, 1)).to.be.undefined;
                expect(mathEnforcer.sum(new Date(), 1)).to.be.undefined;
                expect(mathEnforcer.sum(true, 1)).to.be.undefined;
                expect(mathEnforcer.sum(null, 1)).to.be.undefined;
                expect(mathEnforcer.sum(undefined, 1)).to.be.undefined;
                expect(mathEnforcer.sum(Symbol, 1)).to.be.undefined;
                expect(mathEnforcer.sum(1)).to.be.undefined;
            });
            it("should return undefined for non-valid second argument", function () {
                expect(mathEnforcer.sum(1, "")).to.be.undefined;
                expect(mathEnforcer.sum(1, "String")).to.be.undefined;
                expect(mathEnforcer.sum(1, "5")).to.be.undefined;
                expect(mathEnforcer.sum(1, [])).to.be.undefined;
                expect(mathEnforcer.sum(1, {})).to.be.undefined;
                expect(mathEnforcer.sum(1, new Date())).to.be.undefined;
                expect(mathEnforcer.sum(1, true)).to.be.undefined;
                expect(mathEnforcer.sum(1, null)).to.be.undefined;
                expect(mathEnforcer.sum(1, undefined)).to.be.undefined;
                expect(mathEnforcer.sum(1, Symbol)).to.be.undefined;
            });
        });
    });
});