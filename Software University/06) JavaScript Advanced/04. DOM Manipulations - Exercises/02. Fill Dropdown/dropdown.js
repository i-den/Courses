function addItem() {
    let text = document.getElementById("newItemText").value;
    let value = document.getElementById("newItemValue").value;
    let newOption = document.createElement("option");
    newOption.textContent = text;
    newOption.value = value;
    text.value = '';
    value.value = '';

    document.getElementById("menu").appendChild(newOption);
}