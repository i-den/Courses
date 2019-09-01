function solve(inputArr) {
    let html = '<table>\n';

    for (let json of inputArr) {
        let obj = JSON.parse(json);

        html += '   <tr>\n';
        for (let prop in obj) {
            html += `        <td>${obj[prop]}</td>\n`;
        }
        html += '   </tr>\n';
    }

    return html += '</table>';
}

console.log(solve([
    '{"name":"Pesho","position":"Promenliva","salary":100000}',
    '{"name":"Teo","position":"Lecturer","salary":1000}',
    '{"name":"Georgi","position":"Lecturer","salary":1000}'
]));