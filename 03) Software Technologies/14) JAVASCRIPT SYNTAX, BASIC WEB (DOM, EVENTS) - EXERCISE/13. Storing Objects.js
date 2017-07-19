function solve(arr) {
    let array = new Array();
    for(let string of arr) {
        let tokens = string.split(" -> ");
        let name = tokens[0];
        let age = tokens[1];
        let grade = tokens[2];

        array.push({
            Name: name,
            Age: age,
            Grade: grade
        });
    }

    for(let student of array) {
        for(let key of Object.keys(student)) {
            console.log(`${key}: ${student[key]}`)
        }
    }
}