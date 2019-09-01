function solve(args) {
    let number = Number(args[0]);
    let result = [];

    for (let i = 1; i <= number; i++) {
        if(isSymetric(i + "")) {
            result.push(i);
        }
    }

    console.log(result.join(' '));

    function isSymetric(number) {
        for (let i = 0; i < Math.floor(number.length / 2); i++) {
            if (number[i] !== number[number.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}