function sumArray(inputArray) {
    return inputArray.filter(function(element, index) {
        return (index % 2 === 0 && element !== '');
    }).join(" ");
}