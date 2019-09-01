function validate() {
    let userRegex = /^[a-zA-Z0-9]{3,20}$/;
    let passwdRegex = /^[\w]{5,15}$/;
    let emailRegex = /@.*\./;

    let isCompany = $("#company");
    isCompany.change(isCompanyFn);

    $("#submit").click(validateForm);

    function validateForm(event) {
        event.preventDefault();
        let valid = true;

        // Verify username
        let usernameField = $("#username");
        validateField(usernameField, userRegex);

        // Verify passwords
        let passwordField = $("#password");
        let repeatPasswordField = $("#confirm-password");

        // Equal passwords?
        if (passwordField.val() !== repeatPasswordField.val()) {
            valid = false;
            invalidField(passwordField);
            invalidField(repeatPasswordField);
        } else {
            // Yes - do they meet the requirements?
            validateField(passwordField, passwdRegex);
            validateField(repeatPasswordField, passwdRegex);
        }

        // Verify email
        let emailField = $("#email");
        validateField(emailField, emailRegex);

        // Verify company
        if (isCompany.is(':checked')) {
            let companyRegex = /^[1-9][0-9]{3}$/;
            let companyNumField = $("#companyNumber");
            validateField(companyNumField, companyRegex);
        }

        if (valid) {
            $("#valid").css("display", "inline-block");
        } else {
            $("#valid").css("display", "none");
        }

        function validateField(field, regex) {
            let val = field.val();
            if (regex.test(val)) {
                validField(field);
            } else {
                invalidField(field);
            }
        }

        function invalidField(field) {
            field.css("border", "");
            field.css("border-color", "#ff0000");
            valid = false;
        }

        function validField(field) {
            field.css("border", "none");
        }
    }

    function isCompanyFn() {
        if (isCompany.is(':checked')) {
            $("#companyInfo").css("display", "inline-block");
        } else {
            $("#companyInfo").css("display", "none");
        }
    }
}
