const Film = require('../models/Film');

module.exports = {
	index: (req, res) => {
        Film.find().then(films => {
        	res.render("film/index", {films: films});
		});
	},
	createGet: (req, res) => {
        res.render("film/create");
	},
	createPost: (req, res) => {
        let film = req.body;

        Film.create(film).then(film => {
        	res.redirect('/');
		}).catch(err => {
			console.log(err.message);
			res.redirect('/');
		})
	},
	editGet: (req, res) => {
        let id = req.params.id;

        Film.findById(id).then(film => {
        	res.render("film/edit", film);
		}).catch(err => {
			console.log(err.message);
			res.redirect('/');
		})
	},
	editPost: (req, res) => {
        let id = req.params.id;
        let film = req.body;

        Film.findByIdAndUpdate(id, film, {runValidators: true}).then(film => {
        	res.redirect('/');
		}).catch(err => {
			console.log(err.message);
			res.redirect('/');
		});
	},
	deleteGet: (req, res) => {
        let id = req.params.id;

        Film.findById(id).then(film => {
			res.render('film/delete', film);
		}).catch(err => {
			console.log(err.message);
			res.redirect('/');
		});
	},
	deletePost: (req, res) => {
		let id = req.params.id;

		Film.findByIdAndRemove(id).then(film => {
			res.redirect('/');
		}).catch(err => {
            console.log(err.message);
            res.redirect('/');
        });
	}
};