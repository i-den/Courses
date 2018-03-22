function startApp() {
    const kinvAppKey = "kid_HJ0Ekmbcf";
    const kinvAppSecr = "d86e100c67464f8aa6fd01f9f204871f";
    const kinvBaseURL = "https://baas.kinvey.com";
    const kinvBasicAuth = "Basic " + btoa(kinvAppKey + ':' + kinvAppSecr);

    function kinvAuth() {
        return "Kinvey " + localStorage.getItem("authToken");
    }

    // Header Links
    let headerHome = $("#linkHome");
    let headerLogin = $("#linkLogin");
    let headerRegister = $("#linkRegister");
    let headerListAdds = $("#linkListAds");
    let headerCreateAdd = $("#linkCreateAd");
    let headerEditAdd = $("#viewEditAd");
    let headerLogout = $("#linkLogout");

    // Initiate
    showHideMenuLinks();
    let loadingBox = $("#loadingBox");
    $(document).on({
        ajaxStart: () => loadingBox.show(),
        ajaxStop: () => loadingBox.hide()
    });
    $("#infoBox, #errorBox").on("click", function() {$(this).fadeOut()});

    // Header Links on click to show Body Sections
    headerHome.on("click", () => showView("viewHome"));
    headerLogin.on("click", () => showView("viewLogin"));
    headerRegister.on("click", () => showView("viewRegister"));
    headerCreateAdd.on("click", () => showView("viewCreateAd"));
    headerEditAdd.on("click", () => showView("viewEditAd"));

    // Register
    let registerForm = $("#formRegister");
    registerForm.find("input[type='button']").on("click", registerUser);

    function registerUser(event) {
        event.preventDefault();
        let username = registerForm.find("input[name='username']").val().trim();
        let password = registerForm.find("input[name='passwd']").val().trim();
        if (!(username && password)) {
            showInfo("All fields are mandatory", "errorBox");
            return;
        }

        $.ajax({
            url: `${kinvBaseURL}/user/${kinvAppKey}/`,
            method: "POST",
            headers: {
                "Authorization": kinvBasicAuth,
                "Content-Type": "application/json"
            },
            data: JSON.stringify({
                username: username,
                password: password
            }),
            success: loginSuccess,
            error: handleAjaxError
        });


    }

    // Login
    let loginForm = $("#formLogin");
    loginForm.find("input[type='button']").on("click", loginUser);

    function loginUser(event) {
        event.preventDefault();
        let username = loginForm.find("input[name='username']").val();
        let password = loginForm.find("input[name='passwd']").val();

        if (!(username && password)) {
            showInfo("Both fields are mandatory", "errorBox");
            return;
        }

        $.ajax({
            url: `${kinvBaseURL}/user/${kinvAppKey}/login`,
            method: "POST",
            headers: {
                "Authorization": kinvBasicAuth,
                "Content-Type": "application/json"
            },
            data: JSON.stringify({
                username: username,
                password: password
            }),
            success: loginSuccess,
            error: handleAjaxError
        });
    }

    function loginSuccess(ajaxData) {
        loginForm.find("input[type='text'], input[type='password']").val('');
        registerForm.find("input[type='text'], input[type='password']").val('');
        saveUserInSession(ajaxData);
        showHideMenuLinks();
        showInfo("Welcome!", "infoBox");
    }

    // Logout
    headerLogout.on("click", logoutUser);

    function logoutUser() {
        $.ajax({
            url: `${kinvBaseURL}/user/${kinvAppKey}/_logout`,
            method: "POST",
            headers: {
                "Authorization": kinvAuth()
            },
            success: logoutSuccess,
            error: handleAjaxError
        });

        function logoutSuccess() {
            localStorage.clear();
            showHideMenuLinks();
            showInfo("Successfully logged out", "infoBox");
        }
    }

    // Create
    let createForm = $("#formCreateAd");
    createForm.find("input[type='button']").on("click", createAdvert);

    function createAdvert(event) {
        event.preventDefault();
        let title = createForm.find("input[name='title']").val();
        let description = createForm.find("textarea[name='description']").val();
        let price = createForm.find("input[name='price']").val();

        if (!(title && description && price)) {
            showInfo("All fields are mandatory", "errorBox");
            return;
        }

        $.ajax({
            url: `${kinvBaseURL}/appdata/${kinvAppKey}/ads`,
            method: "POST",
            headers: {
                "Authorization": kinvAuth(),
                "Content-Type": "application/json"
            },
            data: JSON.stringify({
                title: title,
                description: description,
                price: price,
                datePublished: new Date(),
                publisher: localStorage.getItem("username")
            }),
            success: createSuccess,
            error: handleAjaxError
        });

        function createSuccess() {
            createForm.find("textarea, input[type='text'], input[type='number']").val('');
            displayAds();
            showInfo("Advertisement created!", "infoBox");
        }
    }

    // Read
    headerListAdds.on("click", displayAds);

    function displayAds() {
        showView("viewAds");

        $.ajax({
            url: `${kinvBaseURL}/appdata/${kinvAppKey}/ads`,
            method: "GET",
            headers: {
                "Authorization": kinvAuth()
            },
            success: fillAdsInTable,
            error: handleAjaxError
        });
    }

    // Fill Table
    function fillAdsInTable(advertsAjaxData) {
        let tbody = $("#viewAds").find("table");
        tbody.find("tr").not(":eq(0)").remove();

        for (let advert of advertsAjaxData) {
            let tr = $("<tr>")
                .append(`<td>${advert.title}</td>`)
                .append(`<td>${advert.publisher}</td>`)
                .append(`<td>${advert.description}</td>`)
                .append(`<td>${advert.price}</td>`)
                .append(`<td>${parseDate(new Date(advert.datePublished))}</td>`);

            if (advert._acl.creator === localStorage.getItem("userId")) {
                let delAnch = $("<a href='#'>[Delete]</a>");
                let editAnch = $("<a href='#'>[Edit]</a>");

                delAnch.on("click", () => deleteAdvert(advert));
                editAnch.on("click", () => showEditAdScreen(advert));

                tr.append($("<td>")
                    .append(delAnch)
                    .append(editAnch)
                );
            }

            tbody.append(tr);
        }
    }

    // Delete
    function deleteAdvert(advertToDel) {
        $.ajax({
            url: `${kinvBaseURL}/appdata/${kinvAppKey}/ads/${advertToDel._id}`,
            method: "DELETE",
            headers: {
                "Authorization": kinvAuth()
            },
            success: deleteAdvertSuccess,
            error: handleAjaxError
        });

        function deleteAdvertSuccess() {
            displayAds();
            showInfo("Advertisement deleted!", "infoBox");
        }
    }

    // Update
    let editForm = $("#formEditAd");
    editForm.find("input[type='button']").on("click", editAdvert);

    function showEditAdScreen(advertToEdit) {
        editForm.find("input[name='id']").val(advertToEdit._id);
        editForm.find("input[name='publisher']").val(advertToEdit.publisher);
        editForm.find("input[name='title']").val(advertToEdit.title);
        editForm.find("textarea").val(advertToEdit.description);
        editForm.find("input[name='price']").val(advertToEdit.price);

        showView("viewEditAd");
    }
    
    function editAdvert(event) {
        event.preventDefault();
        let id = editForm.find("input[name='id']").val();
        let publisher = editForm.find("input[name='publisher']").val();
        let title = editForm.find("input[name='title']").val();
        let description = editForm.find("textarea").val();
        let price = editForm.find("input[name='price']").val();

        if  (!(id && publisher && title && description && price)) {
            showInfo("All fields are mandatory", "errorBox");
            return;
        }

        $.ajax({
            url: `${kinvBaseURL}/appdata/${kinvAppKey}/ads/${id}`,
            method: "PUT",
            headers: {
                "Authorization": kinvAuth(),
                "Content-Type": "application/json"
            },
            data: JSON.stringify({
                title: title,
                description: description,
                price: price,
                datePublished: new Date(),
                publisher: publisher
            }),
            success: editSuccess,
            error: handleAjaxError
        });

        function editSuccess() {
            displayAds();
            showInfo("Successfully edited advertisement", "infoBox");
        }
    }

    // Helpers
    function parseDate(date) {
        return `${date.getDate()}/${date.getMonth() + 1}/${date.getFullYear()} - ${('0' + date.getHours()).slice(-2)}:${('0' + date.getMinutes()).slice(-2)}`
    }

    function showView(viewId) {
        $("section").hide();
        $('#' + viewId).show();
    }

    function showHideMenuLinks() {
        headerHome.show();
        let loggedInUser = $("#loggedInUser");
        if (localStorage.getItem("authToken") === null) {
            headerLogin.show();
            headerRegister.show();
            headerListAdds.hide();
            headerCreateAdd.hide();
            headerEditAdd.hide();
            headerLogout.hide();
            loggedInUser.hide();
            showView("viewHome");
        } else {
            loggedInUser.text("Welcome " + localStorage.getItem("username"));
            loggedInUser.show();
            headerLogin.hide();
            headerRegister.hide();
            headerListAdds.show();
            headerCreateAdd.show();
            headerEditAdd.show();
            headerLogout.show();
            displayAds();
        }
    }

    function showInfo(msg, type) {
        let infoBox = $('#' + type);
        infoBox.text(msg);
        infoBox.show();
        setTimeout(() => infoBox.fadeOut(), 3000);
    }

    function handleAjaxError(response) {
        let errorMsg = JSON.stringify(response);
        if (response.readyState === 0)
            errorMsg = "Cannot connect due to network error.";
        if (response.responseJSON && response.responseJSON.description)
            errorMsg = response.responseJSON.description;
        showInfo(errorMsg, "errorBox");
    }

    function saveUserInSession(userData) {
        localStorage.setItem("authToken", userData._kmd.authtoken);
        localStorage.setItem("username", userData.username);
        localStorage.setItem("userId", userData._id);
    }
}