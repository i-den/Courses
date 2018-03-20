function attachEvents() {
    const input = $("#location");
    const subBtn = $("#submit");

    const forecastDiv = $("#forecast");
    const currentWeatherDiv = $("#current");
    const upcomingWeatherDiv = $("#upcoming");

    const baseURL = "https://judgetests.firebaseio.com";

    subBtn.click(forecast);

    function forecast() {
        if (!input.val())
            return;

        $.get(`${baseURL}/locations.json`)
            .then(fillForecast)
            .catch(displayErr);

        function fillForecast(ajaxData) {
            let location = ajaxData.filter(x => x.name === input.val())[0];

            let forecastToday = $.get(`${baseURL}/forecast/today/${location.code}.json`);
            let forecastUpcoming = $.get(`${baseURL}/forecast/upcoming/${location.code}.json`);

            Promise.all([forecastToday, forecastUpcoming])
                .then(outputForecast)
                .catch(displayErr);

            function outputForecast([today, upcoming]) {
                let weatherCodes = {
                    "Sunny": "&#x2600;",
                    "Partly sunny": "&#x26C5;",
                    "Overcast": "&#x2601;",
                    "Rain": "&#x2614;",
                    "Degrees": "&#176;"
                };

                currentWeatherDiv
                    .append($(`<span class="condition symbol">${weatherCodes[today.forecast.condition]}</span>`))
                    .append(
                        $(`<span class="condition">`)
                            .append($(`<span>${today.name}</span>`))
                            .append($(`<span class="forecast-data">${today.forecast.low}${weatherCodes["Degrees"]}/${today.forecast.high}${weatherCodes["Degrees"]}</span>`))
                            .append($(`<span class="forecast-data">${today.forecast.condition}</span>`))
                    );

                for (let currForecast of upcoming.forecast) {
                    upcomingWeatherDiv.append(
                        $(`<span class="upcoming">`)
                            .append(`<span class="symbol">${weatherCodes[currForecast.condition]}</span>`)
                            .append(`<span class="forecast-data">${currForecast.low}${weatherCodes["Degrees"]}/${currForecast.high}${weatherCodes["Degrees"]}</span>`)
                            .append(`<span class="forecast-data">${currForecast.condition}</span>`)
                    )
                }
                forecastDiv.show();
            }
        }

        function displayErr(err) {
            console.warn(err);
        }
    }
}