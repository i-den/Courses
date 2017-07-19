function solve(args) {
    let text = args.join(",");
    let words = text
        .split(/\W+/)
        .filter(w => w.length > 0);
    let result = [];

    for (let word of words) {
        if (word === word.toUpperCase()) {
            result.push(word);
        }
    }

    console.log(result.join(', '))
}