class Contact {
    constructor(firstName, lastName, phoneNum, email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.email = email;
        this.online = false;
    }

    render(selector) {
        let article = $("<article>");

        // Title
        let div = $("<div>");
        div.addClass("title");
        div.text(`${this.firstName} ${this.lastName}`);
        let btn = $("<button>&#8505;</button>");

        let infoDiv = $("<div>");
        infoDiv.addClass("info");
        infoDiv.css("display", "none");

        let phone = $(`<span>&phone; ${this.phoneNum}</span>`);
        let email = $(`<span>&#9993; ${this.email}</span>`);

        btn.click(() => {
            infoDiv.toggle();
        });

        infoDiv.append(phone);
        infoDiv.append(email);

        div.append(btn);
        this.titleDiv = div;

        article.append(div);
        article.append(infoDiv);
        $("#" + selector).append(article);
    }

    get online() {
        return this._online;
    }

    set online(online) {
        this._online = online;
        if (this.titleDiv) {
            if (online) {
                this.titleDiv.addClass("online");
            } else {
                this.titleDiv.removeClass("online");
            }
        }
    }
}