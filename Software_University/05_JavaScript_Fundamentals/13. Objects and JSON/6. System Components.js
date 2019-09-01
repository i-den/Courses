function solve(inputArr) {
    let systems = new Map();

    for (let sysInfo of inputArr) {
        let [sysName, component, subcomp] = sysInfo.split(/\s*\|\s*/g);
        chkMem(systems, sysName, new Map());
        chkMem(systems.get(sysName), component, []);
        systems.get(sysName).get(component).push(subcomp);
    }

    for (let [system, sysInfo] of [...systems].sort(sortMap)) {
        console.log(system);
        for (let [component, subcomps] of sysInfo) {
            console.log(`|||${component}`);
            for (let subcomp of subcomps) {
                console.log(`||||||${subcomp}`);
            }
        }
    }

    function chkMem(inpMap, entry, prop) {
        if (!inpMap.has(entry)) {
            inpMap.set(entry, prop);
        }
    }

    return systems;

    function sortMap(a, b) {
        let amCmp = Array.from(b[1].entries()).length - Array.from(a[1].entries()).length;
        if (amCmp === 0) {
            return b[0] < a[0];
        }
        return amCmp;
    }
}

solve([
    'SULS | Main Site | Home Page',
    'SULS | Main Site | Login Page',
    'SULS | Main Site | Register Page',
    'SULS | Judge Site | Login Page',
    'SULS | Judge Site | Submittion Page',
    'Lambda | CoreA | A23',
    'SULS | Digital Site | Login Page',
    'Lambda | CoreB | B24',
    'Lambda | CoreA | A24',
    'Lambda | CoreA | A25',
    'Lambda | CoreC | C4',
    'Indice | Session | Default Storage',
    'Indice | Session | Default Security '
]);



