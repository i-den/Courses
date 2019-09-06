package com.denchevgod.math;

import java.util.*;

public class Arithmetic {

    public static void main(String[] args) {
        System.out.println(Commons.greatestCommonDivisor(231, 110));
    }


    private static class Commons {

        private enum UsingVennDiagToCalc {
            GCD(true), LCM(false);

            boolean val;

            UsingVennDiagToCalc(boolean val) {
                this.val = val;
            }
        }

        /**
         * Calculates the Greatest Common Divisor of multiple numbers
         * using Prime Factorization and multiplying their intersecting Primes
         *
         * @param nums the numbers to calc GCD for
         * @return the Greatest Common Divisor of nums
         */
        static int greatestCommonDivisor(int... nums) {
            return calcCommonDivisorOrMultiple(UsingVennDiagToCalc.GCD, nums);
        }

        /**
         * Calculates the Least Common Multiple of multiple numbers
         * using Prime Factorization and multiplying the all of their Primes
         * to the power of least occurrence
         *
         * @param nums the numbers to calc LCM for
         * @return the Least Common Multiple of nums
         */
        static int leastCommonMultiple(int... nums) {
            return calcCommonDivisorOrMultiple(UsingVennDiagToCalc.LCM, nums);
        }

        static int calcCommonDivisorOrMultiple(UsingVennDiagToCalc vennDiagToCalc, int... nums) {
            if (Primes.allPrimes(nums)) {
                return 1;
            }
            List<List<Integer>> allNumsPrimeFact = Primes.multipleNumsPrimeFactorization(nums);
            Map<Integer, Integer> primeNumsToPow = getIntersectingNumOccurrences(vennDiagToCalc.val, allNumsPrimeFact);
            return primeNumsToPow.keySet().stream()
                    .mapToInt(a -> (int) Math.pow(a, primeNumsToPow.get(a)))
                    .reduce((a, b) -> a * b)
                    .orElse(1); // 1 for GCD
        }


        /**
         * Returns a Map<Integer, Integer> representing Prime Numbers
         * used to calc LCM or GCD and the number of their Occurrences (power)
         * taken from their Prime Factorization
         * <p>
         * GCD uses the Common Intersection Primes from the Prime Factorization of all numbers
         * (https://en.wikipedia.org/wiki/Greatest_common_divisor)
         * <p>
         * LCM uses all Primes in the Prime Factorization to the power of least occurrences
         * (https://en.wikipedia.org/wiki/Least_common_multiple)
         * <p>
         * Examples:
         * Greatest Common Divisor, vennDiagram == true
         * getIntersectingNumOccurrences(true, {
         * { 2:1, 3:3, 5:4 },
         * { 2:2, 5:2, 7:3 }
         * })                     // { 2:1, 5:2 }
         * <p>
         * <p>
         * Least Common Multiple, vennDiagram == false
         * getIntersectingNumOccurrences(true, {
         * { 2:1, 3:3, 5:4 },
         * { 2:2, 5:2, 7:3 }
         * })                     // { 2:1, 3:3, 5:4, 7:3 }
         *
         * @param vennDiagram   Whether the intersection of the Prime Factorization should be used or all Primes
         * @param numsPrimeFact A list containing the Prime Factorization for each number that GCD or LCM is calculated for
         * @return A map of all Primes and their Power that should be used to calculate GCD or LCM
         */
        private static Map<Integer, Integer> getIntersectingNumOccurrences(boolean vennDiagram, List<List<Integer>> numsPrimeFact) {
            List<Map<Integer, Integer>> allNumOccurrences = new ArrayList<>(); // All Primes in their factorization and their number of occurrences (power)
            List<Map<Integer, Integer>> allNumOccurrencesIntersect = new ArrayList<>(); // Using two Lists, simplest way to go :(

            for (List<Integer> integers : numsPrimeFact) {
                Map<Integer, Integer> numOccurrences = new HashMap<>();
                Map<Integer, Integer> numOccurrencesIntersect = new HashMap<>();
                for (Integer integer : integers) {
                    numOccurrences.putIfAbsent(integer, 0);
                    numOccurrencesIntersect.putIfAbsent(integer, 0);
                    numOccurrences.put(integer, numOccurrences.get(integer) + 1);
                    numOccurrencesIntersect.put(integer, numOccurrences.get(integer) + 1);
                }
                allNumOccurrences.add(numOccurrences);
                allNumOccurrencesIntersect.add(numOccurrencesIntersect);
            }

            // Used for GCD, gets all Primes that are present in EVERY number's Prime Factorization
            Set<Integer> primesInAllPrimeFacts = allNumOccurrencesIntersect.stream()
                    .reduce((a, b) -> {
                        a.keySet().retainAll(b.keySet());
                        return a;
                    })
                    .map(Map::keySet)
                    .orElse(allNumOccurrences.get(0).keySet());

            Map<Integer, Integer> intersectingPrimesToPow = new HashMap<>();
            for (Map<Integer, Integer> primPowMap : allNumOccurrences) { // Each Prime Factorization's Prime Power
                for (Map.Entry<Integer, Integer> primPow : primPowMap.entrySet()) { // Each Prime to its Power
                    int prime = primPow.getKey();
                    if (vennDiagram && primesInAllPrimeFacts.contains(prime)) { // GCD
                        intersectingPrimesToPow.putIfAbsent(prime, Integer.MAX_VALUE);
                        intersectingPrimesToPow.put(
                                prime,
                                Math.min(intersectingPrimesToPow.get(prime), primPowMap.get(prime))
                        );
                    } else if (!vennDiagram){ // LCM
                        intersectingPrimesToPow.putIfAbsent(prime, Integer.MIN_VALUE);
                        intersectingPrimesToPow.put(
                                prime,
                                Math.max(intersectingPrimesToPow.get(prime), primPowMap.get(prime))
                        );
                    }
                }
            }
            return intersectingPrimesToPow;
        }

    }

    private static class Primes {

        /**
         * Finds the Prime Factors of an int
         *
         * @param n num to factorize
         * @return a List of integers - the prime factors of the num n
         */
        static List<Integer> primeFactorization(int n) {
            if (n < 1) {
                throw new IllegalArgumentException("1 cannot be Prime Factorized");
            }

            List<Integer> primeFactors = new LinkedList<>();
            int lastKnownPrimeFactor;
            while (n != 1) {
                lastKnownPrimeFactor = findLeastPrimeFactor(n);
                primeFactors.add(lastKnownPrimeFactor);
                n /= lastKnownPrimeFactor;
            }
            return primeFactors;
        }

        /**
         * If n is not a prime it can be factored into two factors - a & b
         * n = a * b
         * If both a & b are greater than the sqrt(n) then their product will be greater than n
         * At least one of the factors is smaller or equal than the sqrt(n)
         * If there are no factors that are less than or equal to sqrt(n) - n is a Prime
         *
         * @param n Number to check the smallest Prime Factor for
         * @return Smallest Prime Factor
         */
        static int findLeastPrimeFactor(int n) {
            if (n % 2 == 0) { // Even - smallest Prime Factor is 2
                return 2;
            }

            int maxPossibleFactor = (int) Math.sqrt(n);
            for (int i = 3; i <= maxPossibleFactor; i += 2) {
                if (n % i == 0) {
                    return i;
                }
            }
            return n; // n is Prime
        }

        static List<List<Integer>> multipleNumsPrimeFactorization(int... nums) {
            List<List<Integer>> primeFactAllNums = new ArrayList<>();
            for (int num : nums) {
                primeFactAllNums.add(Primes.primeFactorization(num));
            }
            return primeFactAllNums;
        }

        static boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            if (num <= 3) {
                return true;
            }
            if (num % 2 == 0 || num % 3 == 0) {
                return false;
            }
            for (int i = 5; i * i <= num; i = i + 6) {
                if (num % i == 0 || num % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }

        static boolean allPrimes(int... nums) {
            for (int num : nums) {
                if (!isPrime(num)) {
                    return false;
                }
            }
            return true;
        }
    }
}