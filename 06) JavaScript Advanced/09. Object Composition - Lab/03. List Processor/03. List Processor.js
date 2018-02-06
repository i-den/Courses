function listProcessor(inputCommands) {

    let commandProcessor = function () {
        let list = [];
        return {
            add: (strToAdd) => list.push(strToAdd),
            remove: (strToRemove) => list = list.filter(e => e !== strToRemove),
            print: () => console.log(list.join(","))
        };
    }();
    
    for (let command of inputCommands) {
        let [currComand, args] = command.split(' ');
        commandProcessor[currComand](args);
    }
}
