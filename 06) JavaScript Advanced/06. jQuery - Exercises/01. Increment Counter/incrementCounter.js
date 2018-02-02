function increment(selector) {
    let container = $(selector);
    let fragment = document.createDocumentFragment();

    let newTxtArea = $("<textarea>");
    newTxtArea.addClass("counter");
    newTxtArea.val(0);
    newTxtArea.prop("disabled", true);

    let incBtn = $("<button>");
    incBtn.addClass("btn");
    incBtn.prop("id", "incrementBtn");
    incBtn.text("Increment");

    let addBtn = $("<button>");
    addBtn.addClass("btn");
    addBtn.prop("id", "addBtn");
    addBtn.text("Add");

    let newUl = $("<ul>");
    newUl.addClass("results");

    incBtn.click(() => {
        newTxtArea.val(Number(newTxtArea.val()) + 1);
    });

    addBtn.click(() => {
        let newLi = $(`<li>${newTxtArea.val()}</li>`);
        newUl.append(newLi);
    });

    newTxtArea.appendTo(fragment);
    incBtn.appendTo(fragment);
    addBtn.appendTo(fragment);
    newUl.appendTo(fragment);

    container.append(fragment);
}