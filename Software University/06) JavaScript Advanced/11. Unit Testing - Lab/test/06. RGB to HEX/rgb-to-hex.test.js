let rgbToHexColor = require("./rgb-to-hex").rgbToHexColor;
let expect = require("chai").expect;

describe("rgbToHexColor(red, green, blue)", function () {
    describe("normal - valid input", function () {
        it('should return #FF9EAA for (255, 158, 170)', function () {
            expect(rgbToHexColor(255, 158, 170)).to.be.equal("#FF9EAA");
        });
        it("should pad values with leading zeroes", function () {
            expect(rgbToHexColor(12, 13, 14)).to.be.equal("#0C0D0E");
        });
        it("should be black for three 0", function () {
            expect(rgbToHexColor(0, 0, 0)).to.be.equal("#000000")
        });
        it("should be white for three 255", function () {
            expect(rgbToHexColor(255, 255, 255)).to.be.equal("#FFFFFF")
        });
    });

    describe("special - non-valid input", function () {
        // Negative
        it("should be undefined for negative red", function () {
            expect(rgbToHexColor(-1, 0, 0)).to.be.equal(undefined);
        });
        it("should be undefined for negative green", function () {
            expect(rgbToHexColor(0, -1, 0)).to.be.equal(undefined);
        });
        it("should be undefined for negative blue", function () {
            expect(rgbToHexColor(0, 0, -1)).to.be.equal(undefined);
        });

        // Overflow
        it("should be undefined for red above 255", function () {
            expect(rgbToHexColor(256, 0, 0)).to.be.equal(undefined);
        });
        it("should be undefined for green above 255", function () {
            expect(rgbToHexColor(0, 256, 0)).to.be.equal(undefined);
        });
        it("should be undefined for blue above 255", function () {
            expect(rgbToHexColor(0, 0, 256)).to.be.equal(undefined);
        });

        // Floating point
        it("should be undefined for floating point red values", function () {
            expect(rgbToHexColor(1.1, 0, 0)).to.be.equal(undefined);
        });
        it("should be undefined for floating point green values", function () {
            expect(rgbToHexColor(0, 1.1, 0)).to.be.equal(undefined);
        });
        it("should be undefined for floating point blue values", function () {
            expect(rgbToHexColor(0, 0, 1.1)).to.be.equal(undefined);
        });

        // Non-number values
        it("should be undefined for red non-number values", function () {
            expect(rgbToHexColor("5", 0, 0)).to.be.equal(undefined);
        });
        it("should be undefined for green non-number values", function () {
            expect(rgbToHexColor(0, "5", 0)).to.be.equal(undefined);
        });
        it("should be undefined for blue non-number values", function () {
            expect(rgbToHexColor(0, 0, "5")).to.be.equal(undefined);
        });

        // Empty
        it("should return undefined for empty input", function () {
            expect(rgbToHexColor()).to.be.equal(undefined);
        });
    })
});