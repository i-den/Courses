function personalBMI(name, age, weight, height) {
    let BMI = Math.round(weight /(height * height / 10000));
    let status;
    if (BMI <= 18.5) {
        status = "underweight";
    } else if (BMI < 25) {
        status = "normal";
    } else if (BMI < 30) {
        status = "overweight";
    } else {
        status = "obese";
    }

    let person = {
        name: name,
        personalInfo: {
            age: age,
            weight: weight,
            height: height
        },
        BMI: BMI,
        status: status
    };

    if (status === "obese") {
        person.recommendation = "admission required";
    }

    return person;
}