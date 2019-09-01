const Calculator = require('./../models/Calculator');

module.exports = {
    indexGet: (req, res) => {
        res.render('home/index');
    },
    indexPost: (req, res) => {
        let calculatorInput = req.body['calculator'];
        let leftOperand = calculatorInput.leftOperand;
        let rightOperand = calculatorInput.rightOperand;
        let operator = calculatorInput.operator;

        let calculator = new Calculator(leftOperand, rightOperand, operator);
        let result = calculator.calculateResult();

        res.render('home/index', {
            result: result,
            calculator: calculator
        })
    }
};