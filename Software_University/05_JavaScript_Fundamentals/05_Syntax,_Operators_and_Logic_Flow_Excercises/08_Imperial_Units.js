function imperialUnits(numberInch) {
    let feet = parseInt(numberInch / 12);
    let inches = numberInch % 12;

    console.log(`${feet}'-${inches}"`)
}