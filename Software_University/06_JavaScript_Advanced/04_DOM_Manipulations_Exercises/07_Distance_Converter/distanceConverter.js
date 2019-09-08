function attachEventsListeners() {
    let rates = {
        "km": 1000,
        "m": 1,
        "cm": 0.01,
        "mm": 0.001,
        "mi": 1609.34,
        "yrd": 0.9144,
        "ft": 0.3048,
        "in": 0.0254
    };

    document.getElementById("convert").addEventListener("click", convert);

    function convert(event) {
        let entryNum = Number(document.getElementById("inputDistance").value);
        let inputUnits = document.getElementById("inputUnits").value;
        let outputUnits = document.getElementById("outputUnits").value;
        let inputMeters = entryNum * rates[inputUnits];
        let outputDistance = inputMeters / rates[outputUnits];

        document.getElementById("outputDistance").value = outputDistance;
    }
}