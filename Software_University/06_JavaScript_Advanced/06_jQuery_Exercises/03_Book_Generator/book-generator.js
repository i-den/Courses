(function bookGenerator() {
    let id = 1;

    return function createBook(selector, title, author, ISBN) {
        let container = $(selector);

        let bookDiv = $(`<div id="book${id}" style="border: medium none;"></div>`);
        let titlePara = $(`<p class="title">${title}</p>`);
        let authorPara = $(`<p class="author">${author}</p>`);
        let isbnPara = $(`<p class="isbn">${ISBN}</p>`);
        let selBtn = $(`<button>Select</button>`);
        let deselBtn = $(`<button>Deselect</button>`);

        selBtn.click(() => {
            bookDiv.css("border", "2px solid blue");
        });

        deselBtn.click(() => {
           bookDiv.css("border", "");
        });

        bookDiv.append(titlePara);
        bookDiv.append(authorPara);
        bookDiv.append(isbnPara);
        bookDiv.append(selBtn);
        bookDiv.append(deselBtn);
        container.append(bookDiv);
        id++;
    }
}())

