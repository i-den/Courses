function domSearch(silektyr, caseSens) {
    // Define container
    let container = $(silektyr);
    container.addClass("items-control");

    // Adding DIV
    let addControls = $(`<div class="add-controls"></div>`);
    let inputLabel = $(`<label>Enter text: </label>`);
    let inputField = $(`<input>`);
    let addAnchor = $(`<a class="button" style="display: inline-block">Add</a>`);

    inputLabel.append(inputField);
    addControls.append(inputLabel);
    addControls.append(addAnchor);

    // Search DIV
    let searchControls = $(`<div class="search-controls"></div>`);
    let searchLabel = $(`<label>Search: </label>`);
    let searchField = $(`<input>`);

    searchLabel.append(searchField);
    searchControls.append(searchLabel);

    // Results DIV
    let resultControls = $(`<div class="result-controls"></div>`);
    let resultList = $(`<ul class="items-list"></ul>`);

    resultControls.append(resultList);

    // Attach everything to the container
    container.append(addControls);
    container.append(searchControls);
    container.append(resultControls);

    // Adding functionality
    addAnchor.click(function (event) {
        // No empty strings
        if (inputField.val() === '') {
            return;
        }

        let newLi = $(`<li class="list-item"></li>`);
        let delAnchor = $(`<a class="button">X</a>`);
        let newEle = $(`<strong>${inputField.val()}</strong>`);

        newLi.append(delAnchor);
        newLi.append(newEle);

        resultList.append(newLi);

        // Deleting functionality
        delAnchor.click(function () {
            newLi.remove();
        })
    });


    searchField.change(function (event) {
        let pattern = '^' + $(this).val() + '$';

        let regex = caseSens
            ? new RegExp(pattern, "i")
            : new RegExp(pattern);

        $(".list-item").filter(function () {
            if (regex.test(($(this).text().substring(1)))) {
                $(this).show();
            } else {
                $(this).hide();
            }
        })
    });
}

