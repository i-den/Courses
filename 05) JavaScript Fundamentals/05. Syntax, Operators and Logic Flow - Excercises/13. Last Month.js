function lastMonth([day, month, year]) {
    let currDate = new Date(year, month - 1, day);
    currDate.setDate(0);

    console.log(currDate.getDate());
}