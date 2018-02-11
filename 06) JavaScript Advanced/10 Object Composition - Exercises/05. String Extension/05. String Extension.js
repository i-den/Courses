(function () {
    String.prototype.ensureStart = function (string) {
        let currentString = this.toString();

        if (currentString.startsWith(string)) {
            return currentString;
        }

        return string + currentString;
    };

    String.prototype.ensureEnd = function (string) {
        let currentString = this.toString();

        if (currentString.endsWith(string)) {
            return currentString;
        }

        return currentString + string;
    };

    String.prototype.isEmpty = function () {
        return this.toString().length === 0;
    };

    String.prototype.truncate = function (number) {
        let currentString = this.toString();

        if (currentString.length <= number) {
            return currentString;
        }

        if (number < 4) {
            return '.'.repeat(number);
        }

        if (!currentString.includes(' ')) {
            return currentString.substr(0, number - 3) + "...";
        }

        let lastSpaceIndex = currentString.substr(0, number - 2).lastIndexOf(' ');
        return currentString.substr(0, lastSpaceIndex) + "...";
    };

    String.format = function (string, ...params) {
        for (let i = 0; i < params.length; i++) {
            string = string.replace(`{${i}}`, params[i]);
        }

        return string;
    }
})();