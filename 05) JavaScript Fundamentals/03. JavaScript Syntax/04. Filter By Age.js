function filterByAge(minAge, ...peopleInfo) {

    let people = [];

    for (let i = 0; i < peopleInfo.length; i += 2) {
        if (peopleInfo[i + 1] >= minAge) {
            people.push({name: peopleInfo[i], age: peopleInfo[i + 1]});
        }
    }

    for (person of people) {
        console.log(person);
    }
}