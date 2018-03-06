function start() {
    const baseUrl = "https://phonebook-66bfc.firebaseio.com/phonebook";
    const phoneBookUL = $("#phoneBook");
    const loadBtn = $("#btnLoad");
    const createBtn = $("#btnCreate");
    const input = {
        person: $("#person"),
        phone: $("#phone")
    };

    loadBtn.click(loadContacts);
    createBtn.click(createContact);
    loadContacts();


    function loadContacts() {
        let loadReq = {
            url: baseUrl + ".json",
            method: "GET",
            success: fillPhoneBookUL,
            error: (e) => console.log(e)
        };
        $.ajax(loadReq);
    }

    function fillPhoneBookUL(ajaxData) {
        phoneBookUL.empty();
        for (let contactKey in ajaxData) {
            if (!ajaxData.hasOwnProperty(contactKey))
                continue;

            let contact = ajaxData[contactKey];

            let delLink = $(`<a href='#'>[Delete]</a>`);
            delLink.click(function () {
                delLink.parent().remove();
                deleteContact(contactKey);
            });

            let li = $(`<li>${contact.name} ${contact.phone} </li>`)
                .append(delLink);

            phoneBookUL.append(li);

            function deleteContact(contactName) {
                let delReq = {
                    url: `${baseUrl}/${contactName}.json`,
                    method: "DELETE",
                    success: () => displayOutput(`Deleted ${contact.name}`, 'e'),
                    error: (err) => displayOutput(`Something bad happened - ${err}`, 'e')
                };
                $.ajax(delReq);
            }
        }
    }

    function createContact() {
        if (input.person.val() === '' && input.phone.val() === '')
            return;

        let createReq = {
            url: baseUrl + ".json",
            method: "POST",
            data: JSON.stringify({
                name: input.person.val(),
                phone: input.phone.val()
            }),
            success: () => {
                loadContacts();
                displayOutput(`${input.person.val()} successfully registered!`, "s");
                input.person.val('');
                input.phone.val('');
            },
            error: (err) => console.log(`Something bad happened - ${err}`, 'e')
        };
        $.ajax(createReq);
    }

    function displayOutput(message, type) {
        let notification = document.getElementById("notification");
        notification.textContent = message;
        notification.style.display = "block";
        switch (type) {
            case 's':
                notification.style.background = "green";
                break;
            case 'e':
                notification.style.background = "red";
                break;
            case 'w':
                notification.style.background = "yellow";
                break;
        }
        setTimeout(() => {
            notification.textContent = '';
            notification.style.display = "none";
        }, 2000)
    }
}