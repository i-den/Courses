const Product = require('../models/Product');

module.exports = {
    index: (req, res) => {
        Product.find().then(products => {
            res.render('product/index', {
                'entries': products
            })
        })
    },
    createGet: (req, res) => {
        res.render('product/create');
    },
    createPost: (req, res) => {
        let productArgs = req.body;

        if (!productArgs.priority
            || !productArgs.name
            || !productArgs.quantity
            || !productArgs.status) {
            res.render('product/index');
            return;
        }

        Product.create(productArgs).then(product => {
            res.redirect('/');
        })
    },
    editGet: (req, res) => {
        let id = req.params.id;

        if (!id) {
            res.redirect('/');
            return;
        }

        Product.findById(id).then(product => {
            res.render("product/edit", product);
        }).catch(err => {
                res.redirect('/');
            }
        )
    },
    editPost: (req, res) => {
        let id = req.params.id;
        let product = req.body;

        if (!id) {
            res.redirect('/');
            return;
        }

        Product.findByIdAndUpdate(id, product, {runValidators: true}).then(product => {
            res.redirect('/');
        }).catch(err => {
            res.redirect('/');
        })

    }
};