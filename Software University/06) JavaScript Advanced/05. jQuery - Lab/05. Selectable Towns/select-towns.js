function attachEvents() {
    $("#items li").click(eventsLi);

    function eventsLi() {
        let currLi = $(this);

        if (currLi.attr("data-selected") === "true") {
            currLi.attr("data-selected", "false");
            currLi.css("background-color", "");
        } else {
            currLi.attr("data-selected", "true");
            currLi.css("background-color", "#DDD");
        }
    }

    $("#showTownsButton").click(showTowns);

    function showTowns() {
        let towns = [];
        $("li[data-selected='true']").toArray().forEach(e => towns.push(e.textContent));
        $("#selectedTowns").text(towns.join(", "));
    }
}