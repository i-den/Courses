let start = -10;
let end = 20;

//Problem 1
while(start < end) {
    console.log(start);
    start++;
}

//Problem 2
start = 10;
end = 40;

while(start <= end) {
    if(start % 2 === 0) {
        console.log(start)
    }

    start++;
}

//Problem 3
start = 300;
end = 333;

while(start <= end) {
    if (start % 2 !== 0) {
        console.log(start);
    }

    start++;
}

//Problem 4
start = 5;
end = 50;

while(start <= end) {
    if(start % 5 === 0 && start % 3 === 0) {
        console.log(start);
    }

    start++;
}