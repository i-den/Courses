function addRemove(inputArray) {
    let outputArr = [];
    for (let i = 1; i <= inputArray.length; i++) {
        switch (inputArray[i - 1]) {
            case "add":
                outputArr.push(i);
                break;
            case "remove":
                outputArr.pop();
                break;
        }
    }

    return outputArr.length > 0
        ? outputArr.forEach(e => console.log(e))
        : "Empty"
}