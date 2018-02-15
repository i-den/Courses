class CheckingAccount {

    constructor(clientId, email, firstName, lastName) {

        this.clientId = clientId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    get clientId() {
        return this._clientId;
    }

    set clientId(clientId) {
        let clientIdRegex = /^[0-9]{6}$/;
        if  (!clientIdRegex.test(clientId)) {
            throw new TypeError("Client ID must be a 6-digit number");
        }
        this._clientId = clientId;
    }

    get email() {
        return this._email;
    }

    set email(email) {
        let emailRegex = /^[a-zA-Z0-9]+@[a-zA-Z.]+/;
        if (!emailRegex.test(email)) {
            throw new TypeError("Invalid e-mail");
        }
        this._email = email;
    }

    get firstName() {
        return this._firstName;
    }

    set firstName(firstName) {
        if (firstName.length < 3 || firstName.length > 20) {
            throw new TypeError("First name must be between 3 and 20 characters long")
        }

        if (!this.verifyName(firstName)) {
            throw new TypeError("First name must contain only Latin characters")
        }
        this._firstName = firstName;
    }

    get lastName() {
        return this._lastName;
    }

    set lastName(lastName) {
        if (lastName.length < 3 || lastName.length > 20) {
            throw new TypeError("First name must be between 3 and 20 characters long")
        }

        if (!this.verifyName(lastName)) {
            throw new TypeError("First name must contain only Latin characters")
        }
        this._lastName = lastName;
    }

    verifyName(name) {
        let nameRegex = /^[a-zA-Z]{3,20}$/;
        return nameRegex.test(name);
    }
}
