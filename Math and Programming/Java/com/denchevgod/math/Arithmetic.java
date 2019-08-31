package com.denchevgod.math;

import java.util.*;

public class Arithmetic {

    public static void main(String[] args) {
        System.out.println(Commons.greatestCommonDivisor(135, 45));
        System.out.println(Commons.leastCommonMultiple(12, 80));
    }


    private static class Commons {
        static int greatestCommonDivisor(int... nums) {
            List<List<Integer>> allNumsPrimeFact = Primes.multipleNumsPrimeFactorization(nums);
            Map<Integer, Integer> primeNumsToPow = getIntersectingNumOccurrences(allNumsPrimeFact, true);
            return primeNumsToPow.keySet().stream()
                    .mapToInt(a -> (int) Math.pow(a, primeNumsToPow.get(a)))
                    .reduce((a, b) -> a * b)
                    .orElse(1);
        }

        static int leastCommonMultiple(int... nums) {
            List<List<Integer>> allNumsPrimeFact = Primes.multipleNumsPrimeFactorization(nums);
            Map<Integer, Integer> primeNumsToPow = getIntersectingNumOccurrences(allNumsPrimeFact, false);
            return primeNumsToPow.keySet().stream()
                    .mapToInt(a -> (int) Math.pow(a, primeNumsToPow.get(a)))
                    .reduce((a, b) -> a * b)
                    .orElse(1);
        }

        private static Map<Integer, Integer> getIntersectingNumOccurrences(List<List<Integer>> numsPrimeFact, boolean vennDiagram) {
            List<Map<Integer, Integer>> allNumOccurrences = new ArrayList<>();

            for (List<Integer> integers : numsPrimeFact) {
                Map<Integer, Integer> numOccurrences = new HashMap<>();
                for (Integer integer : integers) {
                    numOccurrences.putIfAbsent(integer, 0);
                    numOccurrences.put(integer, numOccurrences.get(integer) + 1);
                }
                allNumOccurrences.add(numOccurrences);
            }

            if (vennDiagram) { // GCD
                Set<Integer> intersectingNums = allNumOccurrences.stream()
                        .reduce((a, b) -> {a.keySet().retainAll(b.keySet()); return a;})
                        .map(Map::keySet)
                        .orElse(allNumOccurrences.get(0).keySet());

                Map<Integer, Integer> intersectingNumsToPow = new HashMap<>();
                for (Map<Integer, Integer> currMapNumOccurrences : allNumOccurrences) {
                    for (Map.Entry<Integer, Integer> currNumOccurrences : currMapNumOccurrences.entrySet()) {
                        int currNumKey = currNumOccurrences.getKey();
                        if (intersectingNums.contains(currNumKey)) {
                            intersectingNumsToPow.putIfAbsent(currNumKey, Integer.MAX_VALUE);
                            intersectingNumsToPow.put(
                                    currNumKey,
                                    Math.min(intersectingNumsToPow.get(currNumKey), currMapNumOccurrences.get(currNumKey))
                            );
                        }
                    }
                }
                return intersectingNumsToPow;
            }

            Map<Integer, Integer> intersectingNumsToPow = new HashMap<>();
            for (Map<Integer, Integer> currMapNumOccurrences : allNumOccurrences) {
                for (Map.Entry<Integer, Integer> currNumOccurrences : currMapNumOccurrences.entrySet()) {
                    int currNumKey = currNumOccurrences.getKey();
                    intersectingNumsToPow.putIfAbsent(currNumKey, Integer.MIN_VALUE);
                    intersectingNumsToPow.put(
                            currNumKey,
                            Math.max(intersectingNumsToPow.get(currNumKey), currMapNumOccurrences.get(currNumKey))
                    );
                }
            }
            return intersectingNumsToPow;
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
            static int findLeastPrimeFactor(int n) { //
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
        }
    }
}
