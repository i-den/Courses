function subtract() {
    let firstNum = document.getElementById("firstNumber").value;
    let secNum = document.getElementById("secondNumber").value;
    document.getElementById("result").textContent = Number(firstNum) - Number(secNum);
}