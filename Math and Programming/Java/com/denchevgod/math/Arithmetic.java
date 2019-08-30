package com.denchevgod.math;

import java.util.*;

public class Arithmetic {

    public static void main(String[] args) {
        System.out.println(Commons.greatestCommonDivisor(48, 180));
    }







    private static class Commons {
        static int greatestCommonDivisor(int... nums) {
            List<List<Integer>> allNumsPrimeFact = Primes.multipleNumsPrimeFactorization(nums);
            Map<Integer, Integer> a = getIntersectingNumOccurrences(allNumsPrimeFact, true);



            return 1;
        }

        static int leastCommonMultiple(int... nums) {
            List<List<Integer>> allNumsPrimeFact = Primes.multipleNumsPrimeFactorization(nums);
            return 1;
        }

        private static Map<Integer, Integer> getIntersectingNumOccurrences(List<List<Integer>> numsPrimeFact, boolean vennDiagram) {
            List<List<NumToPow>> allNumOccurrences = new ArrayList<>();

            for (List<Integer> integers : numsPrimeFact) {
                Map<Integer, Integer> numOccurrences = new HashMap<>();
                for (Integer integer : integers) {
                    numOccurrences.putIfAbsent(integer, 0);
                    numOccurrences.put(integer, numOccurrences.get(integer) + 1);
                }
                List<NumToPow> currNumToPows = new ArrayList<>();
                for (Integer currNumKey : numOccurrences.keySet()) {
                    currNumToPows.add(new NumToPow(currNumKey, numOccurrences.get(currNumKey)));
                }
                allNumOccurrences.add(currNumToPows);
            }

            

            return new HashMap<>();
        }

        static class NumToPow {
            int val;
            int pow;
            private NumToPow(int val, int pow) {
                this.val = val;
                this.pow = pow;
            }
            int getVal() {
                return val;
            }
            int getPow() {
                return pow;
            }
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
