function search() {
    let pattern = $("#searchText").val();
    let matched = $(`#towns li:contains(${pattern})`);
    let notMatched = $(`#towns li:not(:contains(${pattern}))`);
    matched.css("font-weight", "bold");
    notMatched.css("font-weight", "");
    $("#result").text(`${matched.length} matches found.`);
}