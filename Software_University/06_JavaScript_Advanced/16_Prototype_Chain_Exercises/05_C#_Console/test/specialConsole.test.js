const expect = require("chai").expect;
let Console = require("../specialConsole").Console;

describe("Console {} tests", function () {
    it("should return the same string", function () {
        let string = "This is a string without placeholders";
        expect(Console.writeLine(string)).to.equal(string);
    });
    it("should return JSON string for an Object argument", function () {
        let object = {Name: "Object"};
        expect(Console.writeLine(object)).to.equal(JSON.stringify(object));
    });
    it("should throw an error for a non-string first argument", function () {
        expect(() => Console.writeLine({}, "1", "2")).to.throw(TypeError);
    });
    it("should throw error if placeholders are less than arguments", function () {
        let string = "This {0} should {1} replaced.";
        expect(() => Console.writeLine(string, "one", "be", "three")).to.throw(RangeError);
    });
    it("should throw error if place of placeholders is changed", function () {
        let string = "This {0} should {0} replaced.";
        expect(() => Console.writeLine(string, "one", "be")).to.throw(RangeError);
    });
    it("should successfully replace placeholders with valid arguments", function () {
        let string = "This {0} should {1} replaced.";
        expect(Console.writeLine(string, "one", "be")).to.equal("This one should be replaced.");
    });
    it("should throw error if invalid placeholder is given", function () {
        let string = "This {0} should {1} replaced. This one {2} not work.";
        expect(() => Console.writeLine(string, "one", "be")).to.throw(RangeError);
    });
    it("should recognize the placeholder numbers well", function () {
        expect(() => Console.writeLine("Not {10}", "valid")).to.throw(RangeError);
    });
});