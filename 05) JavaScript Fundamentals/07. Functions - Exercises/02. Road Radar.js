function roadRadar([speed, drivingArea]) {
    let speedOverflow;

    switch (drivingArea.toLowerCase()) {
        case "motorway":
            speedOverflow = speed - 130;
            break;
        case "interstate":
            speedOverflow = speed - 90;
            break;
        case "city":
            speedOverflow = speed - 50;
            break;
        case "residential":
            speedOverflow = speed - 20;
            break;
    }
    if (speedOverflow <= 0) {
        return '';
    } else if (speedOverflow <= 20) {
        return "speeding";
    } else if (speedOverflow <= 40) {
        return "excessive speeding";
    } else {
        return "reckless driving";
    }
}