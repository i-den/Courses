function tickets(inputArr, criteria) {

    class Ticket {

        constructor(destination, price, status) {

            this.destination = destination;
            this.price = price;
            this.status = status;
        }

        // Original toString() anyway
        toString() {
            return `Ticket { destination: ${this._destination}, price: ${this._price}, status: ${this._status}`
        }

        compareTo(ticket, criteria) {
            switch (criteria) {
                case "destination":
                    return this.destination.localeCompare(ticket.destination);
                case "price":
                    return this.price - ticket.price;
                case "status":
                    return this.status.localeCompare(ticket.status);
            }
        }

        get destination() {
            return this._destination;
        }

        set destination(value) {
            this._destination = value;
        }

        get price() {
            return this._price;
        }

        set price(value) {
            this._price = value;
        }

        get status() {
            return this._status;
        }

        set status(value) {
            this._status = value;
        }

    }

    let tickets = [];

    for (let ticketInfo of inputArr) {
        let [destination, price, status] = ticketInfo.split('|');
        tickets.push(new Ticket(destination, Number(price), status));
    }

    return tickets.sort((a, b) => a.compareTo(b, criteria)).forEach(e => console.log(e + ''));
}