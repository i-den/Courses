function attachEvents() {
    const baseURL = "https://messenger-748a8.firebaseio.com";
    const input = {
        author: $("#author"),
        content: $("#content")
    };
    const subBtn = $("#submit");
    const refresh = $("#refresh");
    let messages = $("#messages");

    subBtn.click(submitMsg);
    refresh.click(getMsgs);

    function submitMsg() {
        if (!input.author.val() || !input.content.val())
            return;

        let chatMsg = {
            author: input.author.val(),
            content: input.content.val(),
            timestamp: Date.now()
        };

        $.ajax({
            url: baseURL + "/.json",
            method: "POST",
            data: JSON.stringify(chatMsg),
            success: function () {
                input.author.val('');
                input.content.val('');
            }
        });
    }

    function getMsgs() {
        $.get(baseURL + "/.json")
            .then(fillMsgs)
            .catch((e) => console.log(e));
    }

    function fillMsgs(ajaxData) {
        let keys = Object.keys(ajaxData);
        let msgsArr = [];
        for (let key of keys) {
            msgsArr.push(ajaxData[key]);
        }
        msgsArr = msgsArr.sort((a, b) => a["timestamp"] - b["timestamp"]);
        messages.empty();
        for (let msg of msgsArr) {
            messages.append(`${msg.author}: ${msg.content}\n`);
        }
    }
}