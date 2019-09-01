const mongoose = require('mongoose');
const objectId = mongoose.Schema.Types.ObjectId;

let entitySchema = mongoose.Schema({
    stringProperty: {type: String, required: true},
    numberProperty: {type: Number, required: true},
	entityRefProperty: {type: objectId, required: true, ref: 'OtherEntity'},
	entityArrProperty: {type: [objectId], default: []},
	dateProperty: {type: Date, default: Date.now()}
});

const Entity = mongoose.model('Entity', entitySchema);

module.exports = Entity;