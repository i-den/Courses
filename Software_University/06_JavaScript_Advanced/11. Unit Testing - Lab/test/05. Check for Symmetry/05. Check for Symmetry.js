describe("Test sum", function () {
    it('should return false for ""', function () {
        expect(isSymmetric("")).to.equal(false);
    });

    it('should return false for 1', function () {
        expect(isSymmetric(1)).to.equal(false);
    });

    it('should return false for {}', function () {
        expect(isSymmetric({})).to.equal(false);
    });

    it('should return false for [1, 2]', function () {
        expect(isSymmetric([1, 2])).to.equal(false);
    });

    it('should return true for [1]', function () {
        expect(isSymmetric([1])).to.equal(true);
    });

    it('should return true for []', function () {
        expect(isSymmetric([])).to.equal(true);
    });

    it('should return true for [1, 2, 3, 3, 2, 1]', function () {
        expect(isSymmetric([1, 2, 3, 3, 2, 1])).to.equal(true);
    });

    describe("Test sum", function () {
        it('should return false for ""', function () {
            expect(isSymmetric("")).to.equal(false);
        });

        it('should return false for 1', function () {
            expect(isSymmetric(1)).to.equal(false);
        });

        it('should return false for {}', function () {
            expect(isSymmetric({})).to.equal(false);
        });

        it('should return false for [1, 2]', function () {
            expect(isSymmetric([1, 2])).to.equal(false);
        });

        it('should return true for [1]', function () {
            expect(isSymmetric([1])).to.equal(true);
        });

        it('should return true for []', function () {
            expect(isSymmetric([])).to.equal(true);
        });

        it('should return true for ["hi", 2, {a: 5}, new Date(), {a: 5}, 2, "hi"]', function () {
            expect(isSymmetric(["hi", 2, {a: 5}, new Date(), {a: 5}, 2, "hi"])).to.equal(true);
        });
    });
});