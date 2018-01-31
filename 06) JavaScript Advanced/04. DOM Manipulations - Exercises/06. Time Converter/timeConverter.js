function attachEventsListeners() {
    let inputs = document.querySelectorAll("div input:nth-child(2)");
    let buttons = document.querySelectorAll("div input:nth-child(3)");
    let fullInputs = [];
    let days, hours, minutes, seconds;

    for (let i = 0; i < buttons.length; i++) {
        let button = buttons[i];
        let input = inputs[i];
        button.addEventListener("click", (event) => {
            let currAmount = button.previousElementSibling.previousElementSibling.innerText;

            switch (currAmount.substring(0, currAmount.length - 1)) {
                case "Days":
                    days = Number(input.value);
                    hours = days * 24;
                    minutes = hours * 60;
                    seconds = minutes * 60;
                    break;
                case "Hours":
                    hours = Number(input.value);
                    days = hours / 24;
                    minutes = hours * 60;
                    seconds = minutes * 60;
                    break;
                case "Minutes":
                    minutes = Number(input.value);
                    hours = minutes / 60;
                    days = hours / 24;
                    seconds = minutes * 60;
                    break;
                case "Seconds":
                    seconds =  Number(input.value);
                    minutes = seconds / 60;
                    hours = minutes / 60;
                    days = hours / 24;
                    break;
            }
            fullInputs = [days, hours, minutes, seconds];

            for (let j = 0; j < inputs.length; j++) {
                inputs[j].value = fullInputs[j];
            }
        });
    }
}