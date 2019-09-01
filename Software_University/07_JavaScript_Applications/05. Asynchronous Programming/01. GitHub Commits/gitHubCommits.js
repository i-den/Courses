    function loadCommits() {
        const input = {
            username: $("#username"),
            repo: $("#repo")
        };
        if (!input.username.val() || !input.repo.val())
            return;

        const commitsUL = $("#commits");

        $.get(`https://api.github.com/repos/${input.username.val()}/${input.repo.val()}/commits`)
            .then(fillUL)
            .catch(displayErr);

        function fillUL(ajaxData) {
            commitsUL.empty();
            for (let commit of ajaxData) {
                commitsUL.append($(`<li>${commit.commit.author.name}: ${commit.commit.message}</li>`))
            }
        }

        function displayErr(error) {
            commitsUL.empty();
            commitsUL.append($(`<li>Error: ${error.status} (${error.responseJSON.message})</li>`));
        }
    }