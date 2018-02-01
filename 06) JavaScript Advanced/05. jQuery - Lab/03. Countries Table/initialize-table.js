function initializeTable() {
    let table = $("#countriesTable");
    table.append(createCountryRow("Bulgaria", "Sofia"));
    table.append(createCountryRow("Germany", "Berlin"));
    table.append(createCountryRow("Russia", "Moscow"));

    $("#createLink").click(insertCountry);
    adjustActions();

    function insertCountry() {
        let inpCountry = $("#newCountryText").val();
        let inpCapital = $("#newCapitalText").val();

        if (inpCapital === ''
        || inpCountry === '') {
            return;
        }

        table.append(createCountryRow(inpCountry, inpCapital));

        $("#newCountryText").val("");
        $("#newCapitalText").val("");
        adjustActions();
    }

    function createCountryRow(name, capital) {
        let newRow = $("<tr>");

        let countryName = $("<td>");
        let capitalName = $("<td>");
        countryName.text(name);
        capitalName.text(capital);

        newRow.append(countryName);
        newRow.append(capitalName);

        let actions = $("<td>");
        let upBtn = $("<a>");
        let downBtn = $("<a>");
        let deleteBtn = $("<a>");

        upBtn.text("[Up]");
        downBtn.text("[Down]");
        deleteBtn.text("[Delete]");

        upBtn.attr("href", "#");
        downBtn.attr("href", "#");
        deleteBtn.attr("href", "#");

        upBtn.click({p1: "up"}, moveAction);
        downBtn.click({p1: "down"}, moveAction);
        deleteBtn.click(deleteAction);

        actions.append(upBtn);
        actions.append(' ');
        actions.append(downBtn);
        actions.append(' ');
        actions.append(deleteBtn);

        newRow.append(actions);

        return newRow;
    }

    function moveAction(event) {
        let currTd = $(this).parent().parent();
        let prev = currTd.prev();
        let next = currTd.next();

        currTd.fadeOut(0);
        currTd.fadeIn(1000);

        switch (event.data.p1) {
            case "up":
                currTd.insertBefore(prev);
                break;
            case "down":
                currTd.insertAfter(next);
                break;
        }

        adjustActions();
    }

    function deleteAction() {
        $(this).parent().parent().remove();
        adjustActions();
    }

    function adjustActions() {
        $("#countriesTable tr:nth-child(3) td:nth-child(3) a:nth-child(1)").hide();
        $("#countriesTable tr:not(:nth-child(3)) td:nth-child(3) a:nth-child(1)").show();
        $("#countriesTable tr:last-child td:nth-child(3) a:nth-child(2)").hide();
        $("#countriesTable tr:not(:last-child) td:nth-child(3) a:nth-child(2)").show();
    }
}