function distanceOverTime(inputArray) {
    let timeInSeconds = inputArray[2];
    let timeInHours = timeInSeconds / (60 * 60);

    let firstVehicleDistanceKm = inputArray[0] * timeInHours;
    let secondVehicleDistanceKm = inputArray[1] * timeInHours;

    let firstVehicleDistanceMeters = firstVehicleDistanceKm * 1000;
    let secondVehicleDistanceMeters = secondVehicleDistanceKm * 1000;

    console.log(Math.abs(firstVehicleDistanceMeters - secondVehicleDistanceMeters));
}