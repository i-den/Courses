const mongoose = require('mongoose');
const Entity = mongoose.model('Entity');

module.exports = {
	//
	// GET: INDEX
	index: (req, res) => {
	let entityPromises = [
		Entity.find({status: 'FirstStatus'}),
		Entity.find({status: 'Second Status'}),
		Entity.find({status: 'Third Status'}),
	];
	//Entity.find({status: 'FirstStatus'}).limit(number);

	Promise.all(entityPromises).then(entityResults => {
		res.render('entity/index', {
			'firstStatEntities': entityResults[0],
			'secondtStatEntities': entityResults[1],
			'thirdStatEntities': entityResults[2]
			});
		});
		
	// Entity.find().populate('entityRefProperty').then(entities => {
	// 	res.render('entity/index', {
	// 		'entities': entities
	//		});
	//	}
	},
		
	//
	// GET: CREATE
    createGet: (req, res) => {
        res.render('entity/create');
    },

	//
	// POST: CREATE
    createPost: (req, res) => {
        let entityArgs = req.body;

        if (!entityArgs.stringProperty 
		|| !entityArgs.numberProperty) {
            res.render('entity/index');
            return;
        }

        Entity.create(entityArgs).then(entity => {
            res.redirect('/');
        }).catch(err => {
            entity.error = 'Cannot create entity';
            res.render('entity/create', entityArgs)
        });
    },	
	
	//
	// GET: READ/5
    detailsGet: (req, res) => {
        let id = req.params.id;
		
		if (!id) {
            res.redirect('/');
            return;
        }
		
        Entity.findById(id).populate('entityRefProperty').then(entity => {
            res.render('entity/details', entity);
        });
    },

	//
	// GET: EDIT/5
	editGet: (req, res) => {
        let id = req.params.id;
		
		if (!id) {
            res.redirect('/');
            return;
        }

        Entity.findById(id).then(entity => {
        	res.render("entity/edit", entity);
		}).catch(err => {
            entity.error = 'Cannot edit entity';
            res.redirect('/');
        });
	},

	//
	// POST: EDIT/5
	editPost: (req, res) => {
        let id = req.params.id;
        let entity = req.body;
		
		if (!id) {
            res.redirect('/');
            return;
        }

        Entity.findByIdAndUpdate(id, entity, {runValidators: true}).then(entity => {
        	res.redirect('/');
		}).catch(err => {
            entity.id = id;
            entity.error = 'Cannot edit entity';

            return res.render('entity/edit', entity);
		}
		
		Entity.update({_id: id}, {$set: {stringProperty: entity.stringProperty, numberProperty: entity.numberProperty}})
            .then(updateStatus => {
                    res.redirect(`/entity/details/${id}`);
                })
	},	
	
	//
	// GET: DELETE/5
    deleteGet: (req, res) => {
        let id = req.params.id;
		
		if (!id) {
            res.redirect('/');
            return;
        }

        Entity.findById(id).then(entity => {
            if (!entity) {
                res.render('entity/index');
                return;
            }

            res.render('entity/delete', entity);
        })
    },	
	
	//
	// POST: DELETE/5
	deletePost: (req, res) => {
		let id = req.params.id;
		
        if (!id) {
            res.redirect('/');
            return;
        }		

		Entity.findByIdAndRemove(id).then(entity => {
			res.redirect('/');
		}).catch(err => {
			res.render('entity/edit', entity);
        });
	}	
}