let movies = [
    'In Bruges',
    'Frozen',
    'Mad Max Fury Road',
    'Les Miserables'
];

let watched = [
    true,
    false,
    true,
    false
];

let stars = [
    5,
    4.5,
    5,
    3.5
];

let moviesArr = [];

for (let i = 0; i < movies.length; i++) {
    let currObj = {
        title: movies[i],
        watched: watched[i],
        stars: stars[i]
    };

    moviesArr.push(currObj);
}

for (let i = 0; i < moviesArr.length; i++) {
    let currObj = moviesArr[i];

    let message = currObj.watched
        ? "You have watched"
        : "You have not seen";

    console.log(`${message} "${currObj.title}" - ${currObj.stars} stars`);
}