function posts() {

    class Post {
        constructor(title, content) {
            this.title = title;
            this.content = content;
        }

        toString() {
            let str = `Post: ${this.title}\n`;
            str += `Content: ${this.content}`;
            return str;
        }
    }

    class SocialMediaPost extends Post {
        constructor(title, content, likes, dislikes) {
            super(title, content);
            this.comments = [];
            this.likes = likes;
            this.dislikes = dislikes;
        }

        addComment(comment) {
            this.comments.push(comment);
        }

        toString() {
            let str = super.toString();
            str += `\nRating: ${this.likes - this.dislikes}`;

            if (this.comments.length > 0) {
                for (let comment of this.comments) {
                    str += `\n* ${comment}`;
                }
            }

            return str;
        }
    }

    class BlogPost extends Post {
        constructor(title, content, views) {
            super(title, content);
            this.views = views;
        }

        toString() {
            let str = super.toString();
            str += `\nViews: ${this.views}`;
            return str;
        }

        view() {
            this.views++;
            return this;
        }
    }

    return {
        Post,
        SocialMediaPost,
        BlogPost
    }
}