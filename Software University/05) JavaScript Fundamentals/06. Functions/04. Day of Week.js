function dayOfWeek(weekDay) {
    let weekDays = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];

    for (let i = 0; i < weekDays.length; i++) {
        if (weekDay === weekDays[i]) {
            return i + 1;
        }
    }

    return "error";
}