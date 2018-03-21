function startApp() {
    // Kinvey
    const kinvAppID = "kid_BJf9ldTFz";
    const kinvAppSecr = "4137ef6f85dd4907aa58264c5026468a";
    const kinvBasicAuthHead = `Basic ${btoa(`${kinvAppID}:${kinvAppSecr}`)}`;
    const kinvBaseURL = "https://baas.kinvey.com";

    // Header
    const headerHome = $("#header-home");
    const headerLogin = $("#header-login");
    const headerRegister = $("#header-register");
    const headerList = $("#header-list");
    const headerCreateBook = $("#header-create-book");
    const headerLogout = $("#header-logout");

    // Main - Home
    const mainHome = $("#main-home");

    // Main - Login
    const mainLogin = $("#main-login");
    const loginUser = $("#input-username");
    const loginPasswd = $("#input-password");

    // Main - Register
    const mainRegister = $("#main-register");

    // Main - Create Book
    const mainCreateBook = $("#create-book");

    // Main - Edit Book
    const editBookTitle = $("#edit-book-title");
    const editBookAuthor = $("#edit-book-author");
    const editBookDesc = $("#edit-book-description");

    // Header Click Events to Show/Hide their Main Counterparts
    headerHome.click(() => showView("main-home"));
    headerLogin.click(() => showView("main-login"));
    headerRegister.click(() => showView("main-register"));
    headerLogout.click(logout);

    headerCreateBook.click(() => showView("create-book"));
    headerList.click(getBooks);

    mainLogin.find("form").submit(login);
    mainRegister.find("form").submit(register);
    mainCreateBook.find("form").submit(createBook);

    $("#infoBox, #errorBox").click(function () {
        $(this).fadeOut();
    });

    $(document).on({
        ajaxStart: () => {
            $("#loadingBox").show()
        },
        ajaxStop: () => {
            $("#loadingBox").hide()
        }
    });

    localStorage.clear();
    showHideMenuLinks();

    // Menu Actions
    function login(event) {
        event.preventDefault();
        let inpUsername = loginUser.val();
        let inpPassword = loginPasswd.val();

        $.ajax({
            url: `${kinvBaseURL}/user/${kinvAppID}/login`,
            method: "POST",
            headers: {
                "Authorization": kinvBasicAuthHead,
                "Content-Type": "application/json"
            },
            data: JSON.stringify({
                username: inpUsername,
                password: inpPassword
            })
        })
            .then(loginSuccess)
            .catch(handleAjaxError);

        function loginSuccess(ajaxData) {
            saveUserInSess(ajaxData);

            loginUser.val('');
            loginPasswd.val('');

            showHideMenuLinks();
            getBooks();
            showInfo("Login Successful");
        }
    }

    function register(event) {
        event.preventDefault();
        let username = $("#register-username").val();
        let password = $("#register-password").val();
        let repeatPassword = $("#register-repeat-password").val();

        if (!(username && password && repeatPassword)) {
            showErr("All fields are mandatory");
            return;
        }

        if (password !== repeatPassword) {
            showErr("Passwords do not match");
            return;
        }

        $.ajax({
            url: `${kinvBaseURL}/user/${kinvAppID}`,
            method: "POST",
            headers: {
                "Authorization": kinvBasicAuthHead,
                "Content-Type": "application/json"
            },
            data: JSON.stringify({
                username: username,
                password: password
            })
        })
            .then(registerSuccess)
            .catch(handleAjaxError);

        function registerSuccess(ajaxData) {
            saveUserInSess(ajaxData);
            showHideMenuLinks();
            getBooks();
            showInfo(`${username} successfully registered`);
        }
    }

    function logout() {
        $.ajax({
            url: `${kinvBaseURL}/user/${kinvAppID}/_logout`,
            method: "POST",
            headers: getKinvAuthHeaders()
        })
            .then(logoutSuccess)
            .catch(handleAjaxError);

        function logoutSuccess() {
            localStorage.clear();
            $("#loggedInUser").text('');

            showHideMenuLinks();

            showView("main-home");
            showInfo("Logout successful");
        }
    }

    // CRUD
    function createBook() {
        let title = $("#create-book-title").val();
        let author = $("#create-book-author").val();
        let description = $("#create-book-description").val();

        if (!(title && author && description)) {
            showErr("All fields are mandatory");
            return;
        }

        $.ajax({
            url: `${kinvBaseURL}/appdata/${kinvAppID}/books`,
            method: "POST",
            headers: getKinvAuthHeaders(),
            data: {
                title: title,
                author: author,
                description: description
            }
        })
            .then(createSuccess)
            .catch(handleAjaxError);

        function createSuccess() {
            getBooks();
            showInfo("Book Created");
        }
    }

    function getBooks() {
        showView("main-books");

        $.ajax({
            url: `${kinvBaseURL}/appdata/${kinvAppID}/books`,
            method: "GET",
            headers: getKinvAuthHeaders()
        })
            .then(showBooks)
            .catch(handleAjaxError);

        function showBooks(booksAjaxData) {
            let tbody = $("#main-books").find("table").find("tbody");
            tbody.empty();

            for (let book of booksAjaxData) {
                let tr = ($("<tr>")
                        .append(`<td>${book.title}</td>`)
                        .append(`<td>${book.author}</td>`)
                        .append(`<td>${book.description}</td>`)
                );

                if (book._acl.creator === localStorage.getItem("userId")) {
                    let editBtn = $(`<a href="#">[&#9998; Edit]</a>`);
                    let delBtn = $(`<a href="#">[&#10005; Delete]</a>`);
                    editBtn.click(() => showEditBook(book));
                    delBtn.click(() => delBook(book._id));

                    tr.append($("<td>")
                        .append(editBtn)
                        .append(delBtn)
                    );
                } else {
                    tr.append(`<td></td>`);
                }

                tbody.append(tr);
            }
        }
    }

    function showEditBook(book) {
        showView("edit-book");

        editBookAuthor.val(book.author);
        editBookDesc.val(book.description);
        editBookTitle.val(book.title);

        $("#edit-book").find("form").submit(editBook);

        function editBook() {
            if (!(editBookAuthor.val()
                    && editBookDesc.val()
                    && editBookTitle.val())) {
                showErr("All fields are mandatory");
                return;
            }

            $.ajax({
                url: `${kinvBaseURL}/appdata/${kinvAppID}/books/${book._id}`,
                method: "PUT",
                headers: getKinvAuthHeaders(),
                data: {
                    title: editBookTitle.val(),
                    description: editBookDesc.val(),
                    author: editBookAuthor.val()
                }
            })
                .then(editSuccess)
                .catch(handleAjaxError);

            function editSuccess() {
                getBooks();
                showInfo("Book Edited");
            }
        }
    }

    function delBook(id) {
        $.ajax({
            url: `${kinvBaseURL}/appdata/${kinvAppID}/books/${id}`,
            method: "DELETE",
            headers: getKinvAuthHeaders()
        })
            .then(deleteSucc)
            .catch(handleAjaxError);

        function deleteSucc() {
            getBooks();
            showInfo(`Successfully deleted book`);
        }
    }

    // Helpers
    function getKinvAuthHeaders() {
        return {
            "Authorization": `Kinvey ${localStorage.getItem("authToken")}`
        }
    }

    function showView(name) {
        $("section").hide();
        $('#' + name).show();

        // switch (name) {
        //     case "home":
        //         $("#main-home").show();
        //         break;
        //     case "login":
        //         $("#main-login").show();
        //         break;
        //     case "register":
        //         $("#main-register").show();
        //         break;
        //     case "books":
        //         $("#main-books").show();
        //         break;
        //     case "create":
        //         $("#create-book").show();
        //         break;
        //     case "edit":
        //         $("#edit-book").show();
        //         break;
        // }
    }

    function showHideMenuLinks() {
        mainHome.show();
        if (null === localStorage.getItem("authToken")) {
            headerLogin.show();
            headerRegister.show();

            headerList.hide();
            headerCreateBook.hide();
            headerLogout.hide();
        } else {
            headerLogin.hide();
            headerRegister.hide();

            headerList.show();
            headerCreateBook.show();
            headerLogout.show();
        }
    }

    function saveUserInSess(userAjaxData) {
        localStorage.setItem("authToken", userAjaxData._kmd.authtoken);
        localStorage.setItem("username", userAjaxData.username);
        localStorage.setItem("userId", userAjaxData._id);

        $("#loggedInUser").text("Welcome " + userAjaxData.username);
    }

    // Info
    function showInfo(msg) {
        let infoBox = $("#infoBox");
        infoBox.text(msg);
        infoBox.show();
        setTimeout(() => infoBox.fadeOut(), 3000)
    }

    function showErr(msg) {
        let errorBox = $("#errorBox");
        errorBox.text(msg);
        errorBox.show();
        setTimeout(() => errorBox.fadeOut(), 3000)
    }

    function handleAjaxError(response) {
        let errorMsg = JSON.stringify(response);
        if (response.readyState === 0)
            errorMsg = "Cannot connect due to network error.";
        if (response.responseJSON && response.responseJSON.description)
            errorMsg = response.responseJSON.description;
        showErr(errorMsg);
    }
}