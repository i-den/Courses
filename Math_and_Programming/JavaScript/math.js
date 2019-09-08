function quickMaths() {

    /**
     *  Least Common Multiple - return the LCM of several Numbers
     *  Examples:
     *  leastCommonMultiple(65, 10, 5)       // 130
     *  leastCommonMultiple(6, 4)            // 42
     *  leastCommonMultiple(36, 18, 6, 3)    // 36
     */
    function leastCommonMultiple(...numbers) {
        let primes = getNumPowObj(numbers);
        primes = primeNumObjsToOccurrences(primes);
        return numPowObjToProduct(primes);
    }

    /**
     *  Greatest Common Divisor - returns the GCD of several Numbers
     *  Examples:
     *  greatestCommonDivisor(48, 180)       // 12
     *  greatestCommonDivisor(6, 12, 18)     // 6
     */
    function greatestCommonDivisor(...numbers) {
        let primes = getNumPowObj(numbers);
        let intersectKeys = getObjIntersects(primes);
        primes = primeNumObjsToOccurrences(primes, intersectKeys);
        return numPowObjToProduct(primes);
    }

    /**
     *  Returns all factors for a Number that make it divisible without remainder
     *  If negativesIncluded is true it will also include all negative numbers as well
     *  Examples:
     *  findAllFactors(5)           // [1, 5]
     *  findAllFactors(6, true)     // [1, 2, 3, -1, -2, -3]
     *  findAllFactors(18)          // [1, 2, 3, 6, 9]
     */
    function findAllFactors(number, negativesIncluded) {
        let smallestPrimeFactor = findSmallestPrimeFactor(number);
        let maxPossibleFactor = number / smallestPrimeFactor;
        let allFactors = [1];

        if  (smallestPrimeFactor === 2) {
            allFactors.push(smallestPrimeFactor);
            smallestPrimeFactor++;
        }

        for (let i = smallestPrimeFactor; i <= maxPossibleFactor; i++) {
            if  (number % i === 0)
                allFactors.push(i);
        }
        allFactors.push(number);

        if (negativesIncluded)
            allFactors.forEach((num) => allFactors.push(num * -1));

        return allFactors;
    }

    /**
     *  Takes the Input Numbers and breaks them down to Objects like
     *  {PrimNum, PrimNumOccurrenceCount}
     *
     *  1. Breaks down each Number to it's Prime Factorization stored in Array
     *  2. Each Prime Factorization Array becomes an {PrimNum, PrimNumOccurrenceCount} Object
     *  Examples:
     *
     *  getNumPowObj[18, 36]
     *  For 18
     *  1. [2, 3, 3]
     *  2. {'2': 1, '3': 2}
     *
     *  For 36
     *  1. [2, 2, 3, 3]
     *  2. {'2': 2, '3': 2}
     *
     *  [
     *      {'2': 1, '3': 2},
     *      {'2': 2, '3': 2}
     *  ]
     */
    function getNumPowObj(numbers) {
        let primes = [];
        for (let number of numbers) {
            primes.push(primeFactorization(number));
        }
        return primes.map(primesToPowerObj);

        /**
         *  Primes to Power Object
         *  Takes an array of prime numbers and returns an Object with each Element for key and it's occurrences as values
         *  Examples:
         *  primesToPowerObj([1, 3, 3])             // {'1': 1, '3': 2}
         *  primesToPowerObj([3, 3, 5, 5, 5, 7])    // {'3': 2, '5': 3, '7': 1}
         */
        function primesToPowerObj(arr) {
            let primesObj = {};
            for (let primeNum of arr) {
                if (!primesObj[primeNum])
                    primesObj[primeNum] = 0;
                primesObj[primeNum]++;
            }
            return primesObj;
        }
    }

    /**
     *  Prime Factorization - returns all Prime Numbers
     *  that are Factors for a number
     *
     *  Code taken from Project Nayuki
     *  Copyright (c) 2017 Project Nayuki
     *  All rights reserved. Contact Nayuki for licensing.
     *  https://www.nayuki.io/page/calculate-prime-factorization-javascript
     *
     *  @param number - The number that will be broken down to Prime Numbers
     *  @returns {Array} - Array of all the Prime Numbers that are Factors for number
     *
     *  Examples:
     *  primeFactorization(21)   // [ 3, 7 ]
     *  primeFactorization(42)   // [ 2, 3, 7 ]
     *  primeFactorization(155)  // [ 5, 31 ]
     */
    function primeFactorization(number) {
        if (number < 1) {
            throw new RangeError("Number is less than 2");
        }
        let result = [];
        while (number !== 1) {
            let currentFactor = findSmallestPrimeFactor(number);
            result.push(currentFactor);
            number /= currentFactor;
        }
        return result;
    }

    /**
     *  Copyright (c) 2017 Project Nayuki
     *  All rights reserved. Contact Nayuki for licensing.
     *  https://www.nayuki.io/page/calculate-prime-factorization-javascript
     *
     *  Finds the Smallest Prime Factor for a Number
     *  Examples:
     *  findSmallestPrimeFactor(3) // 3
     *  findSmallestPrimeFactor(6) // 2
     *  findSmallestPrimeFactor(25) // 5
     */
    function findSmallestPrimeFactor(n) {
        if (n % 2 === 0) {
            return 2;
        }

        let maximumPossibleFactor = Math.round(Math.sqrt(n));
        for (let i = 3; i <= maximumPossibleFactor; i += 2) {
            if (n % i === 0) {
                return i;
            }
        }
        // Number is prime
        return n;
    }

    /**
     *  Returns an Array of all Prime numbers within the range of Star - End, inclusive
     *  Uses Sieve of Eratosthenes - https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     *  Examples:
     *  findPrimesInRange(1, 23)    // [ 1, 2, 3, 5, 7, 11, 13, 17, 19, 23 ]
     *  findPrimesInRange(5, 16)    // [ 5, 7, 9, 11, 13 ]
     */
    function findPrimesInRange(start, end) {
        let primes = [];
        let tempArr = [];

        // If starting number is either 0, 1 or 2
        start = Math.max(start, 1);
        if (start < 3) {
            for (let i = start; i <= 2; i++) {
                tempArr.push(i);
            }
            start = 3;
        }

        if (start % 2 === 0)
            start++;
        for (let i = start; i <= end; i += 2) {
            primes.push(i);
        }

        let currPrimeIndex = 0;
        while (currPrimeIndex <= primes.length) {
            let prime = primes[currPrimeIndex];
            primes = primes.filter((num) => num % prime !== 0 || num === prime);
            currPrimeIndex++;
        }

        // If start was below 3, add unshift the numbers
        if (tempArr.length > 0) {
            for (let i = tempArr.length - 1; i >= 0; i--) {
                primes.unshift(tempArr[i]);
            }
        }

        return primes;
    }

    /**
     *  Returns {Number, NumberPower} Object containing either the
     *  Greatest Common Divisor (Venn Diagram Intersection)
     *  All Numbers found in all Arrays to their minimum power or
     *
     *  Least Common Multiple
     *  All Numbers found in both Arrays and their maximum power
     *
     *  Examples:
     *  Greatest Common Divisor, vennDragram === true
     *  primeNumObjsToOccurrences([
     *      {'1': 1, '3': 3, '5': 4},
     *      {'3': 2, '5': 3, '7': 1}
     *  ])                              // {'3': 2, '5': 3,}
     *
     *
     *  Least Common Multiple, vennDiagram === false
     *  primeNumObjsToOccurrences([
     *      {'1': 1, '3': 3, '5': 4},
     *      {'3': 2, '5': 3, '7': 1}
     *  ])                              // {'1': 1, '3': 3, '5': 4, '7': 1
     *
     */
    function primeNumObjsToOccurrences(arr, vennDiagram) {
        let sharedPrimes = {};

        for (let primeObj of arr) {
            let keys = vennDiagram
                ? vennDiagram
                : Object.keys(primeObj);

            for (let key of keys) {
                if (!sharedPrimes[key])
                    sharedPrimes[key] = vennDiagram
                        ? Number.MAX_SAFE_INTEGER
                        : Number.MIN_SAFE_INTEGER;

                if (!vennDiagram)
                    sharedPrimes[key] = Math.max(sharedPrimes[key], primeObj[key]);
                else
                    sharedPrimes[key] = Math.min(sharedPrimes[key], primeObj[key]);
            }
        }

        return sharedPrimes;
    }

    /**
     *  Returns the Product of an Array of Objects {Num: Power}
     *  Examples:
     *  numPowObjToProduct({'1': 1, '3': 3, '5': 4})   // 1^1 * 3^3 * 5^4 = 1 * 9 * 625 = 5625
     *  numPowObjToProduct({'3': 2, '5': 3, '7': 1})   // 3^2 * 5^3 * 7^1 = 6 * 125 * 7 = 5250
     */
    function numPowObjToProduct(primesArr) {
        let primesPow = [];
        let keys = Object.keys(primesArr);
        for (let key of keys) {
            primesPow.push(Math.pow(Number(key), primesArr[key]));
        }
        return primesPow.reduce((a, b) => a * b);
    }

    /**
     *  Returns the Intersection of multiple Arrays built of {Number, Power} Objects, Number present in all Objects
     *  Examples:
     *  getObjIntersects([
     *      {'1': 1, '3': 3, '5': 4},
     *      {'3': 2, '5': 3, '7': 1}
     *  ])                              // [3, 5]
     */
    function getObjIntersects(objects) {
        let objKeys = [];
        for (let object of objects) {
            objKeys.push(Object.keys(object));
        }
        return objKeys.reduce(reducer);

        function reducer(firstArr, secArr) {
            return firstArr.filter((key) => {
                return secArr.indexOf(key) !== -1;
            })
        }
    }

    return {
        primeFactorization,
        leastCommonMultiple,
        greatestCommonDivisor,
        findAllFactors,
        findPrimesInRange
    }
}

let c = quickMaths();