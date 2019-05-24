function generateSummary(selector) {
    $(selector).click(function () {
        let summaryText = $("#content strong").text();
        createSummary(summaryText);
    });

    function createSummary(summaryText) {
        let div = $("<div>");
        div.attr("id", "summary");

        let heading = $("<h2>");
        heading.text("Summary");

        let p = $("<p>");
        p.text(summaryText);

        div.append(heading);
        div.append(p);

        $("#content").parent().append(div);
    }
}