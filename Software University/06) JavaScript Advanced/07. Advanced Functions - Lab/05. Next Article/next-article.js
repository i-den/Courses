function getArticleGenerator(arts) {

    return function() {
        if (arts.length === 0) {
            return;
        }
        let article = $("<article>");
        article.append($(`<p>${arts.shift()}</p>`))
        $("#content").append(article);
    }
}