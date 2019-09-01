class MailBox {
    constructor() {
        this.mailBox = new Map();
    }

    addMessage(subject, text) {
        this.mailBox.set(subject, text);
        return this;
    }

    get messageCount() {
        return Array.from(this.mailBox.keys()).length;
    }

    deleteAllMessages() {
        this.mailBox.clear();
    }

    findBySubject(substr) {
        let messages = [];

        let keys = Array.from(this.mailBox.keys());
        for (let key of keys) {
            if (new RegExp(substr).test(key)) {
                // let obj = {};
                // obj[key] = this.mailBox.get(key);
                messages.push({subject: key, text: this.mailBox.get(key)});
            }
        }

        return messages;
    }

    toString() {
        if  (this.messageCount === 0) {
            return " * (empty mailbox)";
        }

        let str = '';
        let keys = Array.from(this.mailBox.keys());
        for (let key of keys) {
            str += `\n * ${key} ${this.mailBox.get(key)}`
        }
        return str;
    }
}