function leapYear(inputYear) {
    if (inputYear % 400 === 0
        || (inputYear % 4 === 0 && inputYear % 100 !== 0)) {
        return 'yes';
    }

    return 'no';
}