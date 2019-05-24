function addOneDay(year, month, day) {

    let currentDate = new Date(Number(year), Number(month) - 1, Number(day));

    currentDate.setDate(currentDate.getDate() + 1);

    // console.log('Year is ' + currentDate.getFullYear());
    // console.log(`Month is ${currentDate.getMonth() + 1}`);
    // console.log(`Day is ${currentDate.getDate()}`);

    console.log(`${currentDate.getFullYear()}-${currentDate.getMonth() + 1}-${currentDate.getDate()}`)
}