let start = -10;
let end = 20;

//Problem 1
for(let i = start; i < end; i++) {
    console.log(i);
}

//Problem 2
start = 10;
end = 40;

for(let i = start; i <= end; i++) {
    if(i % 2 === 0) {}
    console.log(i);
}

//Problem 3
start = 300;
end = 333;

for(let i = start; i <= end; i++) {
    if (i % 2 !== 0) {
        console.log(i);
    }
}

//Problem 4
start = 5;
end = 50;

for(let i = start; i<= end; i++){
    if(i % 5 === 0 && i % 3 === 0){
        console.log(i);
    }
}