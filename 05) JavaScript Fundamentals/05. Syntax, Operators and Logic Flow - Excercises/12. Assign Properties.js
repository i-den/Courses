function composePesho(args) {
    let obj = {};

    for (let i = 0; i < args.length; i += 2) {
        let key = args[i];
        let val = args[i + 1];
        obj[key] = val;
    }

    console.log(obj);
}