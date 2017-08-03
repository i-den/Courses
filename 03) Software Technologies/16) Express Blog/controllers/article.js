const mongoose = require('mongoose');
const Article = mongoose.model('Article');

module.exports = {
    createGet: (req, res) => {
        res.render('article/create')
    },

    createPost: (req, res) => {
        let articleArgs = req.body;

        let errorMsg = '';

        if (!req.isAuthenticated()) {
            errorMsg = 'Please log in';
        } else if (!articleArgs.title) {
            errorMsg = 'Please enter a title';
        } else if (!articleArgs.content) {
            errorMsg = 'Please write content';
        }

        if (errorMsg) {
            res.render('article/view', {
                error: errorMsg
            });
        } else {
            articleArgs.author = req.user.id;

            Article.create(articleArgs).then(article => {
                req.user.articles.push(article);

                req.user.save(err => {
                    if (err) {
                        res.redirect('/', {
                            error: err.message
                        });
                    } else {
                        res.redirect('/');
                    }
                });
            });
        }
    },

    detailsGet: (req, res) => {
        let id = req.params.id;
        Article.findById(id).populate('author').then(article => {
            res.render('article/details', article);
        });
    },

    editGet: (req, res) => {
        let id = req.params.id;

        Article.findById(id).then(article => {
            res.render('article/edit', article);
        });
    },

    editPost: (req, res) => {
        let id = req.params.id;

        let articleArgs = req.body;

        let errorMsg = '';

        if (!req.isAuthenticated()) {
            errorMsg = 'Please login in order to edit articles';
        } else if (!articleArgs.title) {
            errorMsg = 'Please choose a title';
        } else if (!articleArgs.content) {
            errorMsg = 'Please enter content';
        }

        if (errorMsg) {
            res.render('article/edit', {
                error: errorMsg
            });
        } else {
            Article.update({_id: id}, {$set: {title: articleArgs.title, content: articleArgs.content}})
                .then(updateStatus => {
                    res.redirect(`/article/details/${id}`);
                })
        }
    },

    deleteGet: (req, res) => {
        let id = req.params.id;

        Article.findById(id).then(article => {
            res.render('article/delete',
                article
            )
        });
    },

    deletePost: (req, res) => {
        let id = req.params.id;

        Article.findOneAndRemove({_id: id}).populate('author').then(article => {
           let author = article.author;

           let index = author.articles.indexOf(article.id);

           if(index < 0) {
               let errorMsg = 'Article was not found for that author';
               res.render('article/delete', {
                   error: errorMsg
               });
           } else {
                author.articles.splice(index, count);
                author.save().then((user) => {
                    res.redirect('/');
                });
           }
        });
    },
};