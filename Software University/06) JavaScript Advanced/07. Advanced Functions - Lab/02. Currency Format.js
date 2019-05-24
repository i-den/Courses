function currencyFormatter(separator, symbol, isSymbolFirst, value) {
    let result = Math.trunc(value) + separator;
    result += value.toFixed(2).substr(-2, 2);

    return isSymbolFirst
        ? `${symbol} ${result}`
        : `${result} ${symbol}`
}

function dollarFormatter(formatter) {
    return function (value) {
        return formatter(',', '$', true, value);
    }
}

let dollars = dollarFormatter(currencyFormatter);
console.log(dollars(150));