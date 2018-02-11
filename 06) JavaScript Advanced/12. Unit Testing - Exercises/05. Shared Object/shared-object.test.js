const sharedObject = require("./shared-object").sharedObject;

const expect = require("chai").expect;
const jsdom = require("jsdom-global")();
const $ = require("jquery");

document.body.innerHTML = `<div id="wrapper">
        <input type="text" id="name">
        <input type="text" id="income">
    </div>`;

describe("sharedObject{name, income, changeName(name), changeIncome(income), updateName(), updateIncome()}", function () {
    before(function () {
        global.$ = $;
    });

    describe("sharedObject{name, income}", function () {
        it("should have null initial values", function () {
            expect(sharedObject.name).to.be.null;
            expect(sharedObject.income).to.be.null;
        });
    });

    describe("sharedObject.changeName(name)", function () {
        it("should return null for '' argument", function () {
            sharedObject.changeName('');
            expect(sharedObject.name).to.be.null;
        });
        it("should change it's name to Name for (\"Name\")", function () {
            sharedObject.changeName("Name");
            sharedObject.changeName('');
            expect(sharedObject.name).to.equal("Name", "name property didn't change");
            expect($("#name").val()).to.equal("Name", "name property didn't change");
        });
        it("should change it's name to Pesho after changing first to Gosho, then Pesho", function () {
            sharedObject.changeName("Gosho");
            sharedObject.changeName("Pesho");
            expect(sharedObject.name).to.equal("Pesho", "name property didn't change - Gosho -> Pesho");
            expect($("#name").val()).to.equal("Pesho", "name property didn't change - Gosho -> Pesho");
        });
    });

    describe("sharedObject.changeIncome(income)", function () {
        it("should return 10 for (10)", function () {
            sharedObject.changeIncome(10);
            sharedObject.changeIncome(0);
            sharedObject.changeIncome(-10);
            expect(sharedObject.income).to.be.equal(10);
            expect($("#income").val()).to.be.equal("10");
        });
    });

    describe("sharedObject.updateName()", function () {
        it("should return Gosho", function () {
            $("#name").val("Gosho");
            sharedObject.updateName();
            $("#name").val("");
            sharedObject.updateName();
            expect(sharedObject.name).to.be.equal("Gosho");
        });
        it("should return Gosho", function () {
            let name = $("#name");
            name.val("Gosho");
            name.val("");
            sharedObject.updateName();
            expect(sharedObject.name).to.be.equal("Gosho");
            expect(name.val()).to.be.equal("");
        });
    });

    describe("updateIncome function", function () {
        it("should return previous value if value is NaN", function () {
            sharedObject.changeIncome(15);
            $("#income").val("abc");
            sharedObject.updateIncome();
            expect(sharedObject.income).to.equal(15);
            expect($("#income").val()).to.equal("abc");
        });
        it("should return previous value if value is floating point number", function () {
            sharedObject.changeIncome(15);
            $("#income").val("3.6");
            sharedObject.updateIncome();
            expect(sharedObject.income).to.equal(15);
            expect($("#income").val()).to.equal("3.6");
        });
        it("should return previous value if value is negative number", function () {
            sharedObject.changeIncome(15);
            $("#income").val("-10");
            sharedObject.updateIncome();
            expect(sharedObject.income).to.equal(15);
            expect($("#income").val()).to.equal("-10");
        });
        it("should return previous value if value is 0", function () {
            sharedObject.changeIncome(15);
            $("#income").val("0");
            sharedObject.updateIncome();
            expect(sharedObject.income).to.equal(15);
            expect($("#income").val()).to.equal("0");
        });
        it("should return correct value id value is positive integer", function () {
            sharedObject.changeIncome(15);
            $("#income").val("20");
            sharedObject.updateIncome();
            expect(sharedObject.income).to.equal(20);
            expect($("#income").val()).to.equal("20");
        })
    });
});