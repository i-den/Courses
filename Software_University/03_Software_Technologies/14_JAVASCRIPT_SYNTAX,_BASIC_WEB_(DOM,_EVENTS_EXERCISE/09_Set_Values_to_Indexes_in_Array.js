function solve(args) {
    let number = Number(args[0]);
    let myArr = Array(number).fill(0);

    for (let i = 1; i < args.length; i++) {
        let currentStringParams = args[i].split(' - ');
        let currIndice = Number(currentStringParams[0]);
        let currNumber = Number(currentStringParams[1]);

        myArr[currIndice] = currNumber;
    }

    for (let i = 0; i < number; i++) {
        console.log(myArr[i]);
    }
}