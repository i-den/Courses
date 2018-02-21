function move(command) {
    switch (command) {
        case "right":
            moveRight();
            break;
        case "left":
            moveLeft();
            break;
        case "print":
            printSelected();
            break;
    }

    function moveRight() {
        $("#available-towns option:selected").appendTo($("#selected-towns"));
        $("#selected-towns option:selected").prop("selected", false);
    }

    function moveLeft() {
        $("#selected-towns option:selected").appendTo($("#available-towns"));
        $("#available-towns option:selected").prop("selected", false);
    }

    function printSelected() {
        let text = $.map($("#selected-towns").children(), (e) => $(e).text()).join("; ");
        $("#output").text(text);
    }
}