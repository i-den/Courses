const mongoose = require('mongoose');
const Task = mongoose.model('Task');

module.exports = {
    index: (req, res) => {
        let taskPromises = [
            Task.find({status: 'Open'}),
            Task.find({status: 'In Progress'}),
            Task.find({status: 'Finished'}),
        ];

        Promise.all(taskPromises).then(taskResults => {
            res.render('task/index', {
                'openTasks': taskResults[0],
                'inProgressTasks': taskResults[1],
                'finishedTasks': taskResults[2]
            });
        });
    },
    createGet: (req, res) => {
        res.render('task/create');
    },
    createPost: (req, res) => {
        let task = req.body;

        Task.create(task).then(task => {
            res.redirect("/");
        }).catch(err => {
            task.error = 'Cannot create task';
            res.render('task/create', task)
        })
    },
    editGet: (req, res) => {
        let id = req.params.id;

        Task.findById(id).then(task => {
            res.render('task/edit', task);
        })
    },
    editPost: (req, res) => {
        let taskId = req.params.id;
        let task = req.body;

        Task.findByIdAndUpdate(taskId, task, {runValidators: true}).then(tasks => {
            res.redirect('/');
        }).catch(err => {
            task.id = taskId;
            task.error = 'Cannot edit task';

            return res.render('task/edit', task);
        })
    }
};