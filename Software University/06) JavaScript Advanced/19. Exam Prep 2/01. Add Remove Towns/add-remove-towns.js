function attachEvents() {
    $("#btnAdd").click(add);
    $("#btnDelete").click(remove);

    function add() {
        let textToAdd = $("#newItem").val();
        if (textToAdd === '') {
            return;
        }
        $("#towns").append($("<option>").text(textToAdd));
        $("#newItem").val('');
    }

    function remove() {
        $("#towns option:selected").remove();
    }
}