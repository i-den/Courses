function solve(arr) {
    arr = arr.filter(x => x !== "");
    for (let i = 0; i < arr.length; i++) {
        let currString = JSON.parse(arr[i]);

        for (let prop in currString) {
            let currStr = prop.charAt(0).toUpperCase() + prop.slice(1);
            console.log(`${currStr}: ${currString[prop]}`)
        }
    }
}