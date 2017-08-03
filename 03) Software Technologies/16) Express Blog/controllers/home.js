const Article = require('mongoose').model('Article');

module.exports = {
  index: (req, res) => {
      Article.find({}).populate('author').limit(6).then(articles => {
          res.render('home/index', {
              articles: articles
          });
      });
  }
};