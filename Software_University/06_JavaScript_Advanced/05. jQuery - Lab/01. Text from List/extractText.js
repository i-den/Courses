function extractText() {
    let text = [];
    Array.from($("ul li")).forEach(e => text.push(e.textContent));
    $("#result").text(text.join(", "));
}