function deckOfCards(cards) {
    let cardFactory = (function () {
        function makeCard(face, suit) {
            let validFaces = [2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K', 'A'];

            let validSuits = {
                'S': "\u2660",
                'H': "\u2665",
                'D': "\u2666",
                'C': "\u2663"
            };

            if (!validFaces.includes(face)
                && !validFaces.includes((Number(face)))) {
                throw new Error("Invalid Card Face");
            }

            if (!Object.keys(validSuits).includes(suit)) {
                throw new Error("Invalid Card Suit");
            }

            let obj = {
                face: face,
                suit: validSuits[suit],
                toString: () => obj.face + obj.suit
            };

            return obj;
        }

        return {
            makeCard
        }
    })();

    let validCards = [];
    let invalidCards = [];

    for (let card of cards) {
        let face = card.substr(0, card.length - 1);
        let suit = card.substr(-1);

        try {
            validCards.push(cardFactory.makeCard(face, suit));
        } catch (e) {
            return console.log(`Invalid card: ${card}`);
        }
    }

    console.log(validCards.join(' '));
}