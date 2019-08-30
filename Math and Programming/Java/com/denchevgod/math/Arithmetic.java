package com.denchevgod.math;

import java.util.LinkedList;
import java.util.List;

public class Arithmetic {
    
    private static class Primes {

        /**
         * Finds the Prime Factors of an int
         *
         * @param   n   num to factorize
         * @return      a List of integers - the prime factors of the num n
         */
        private static List<Integer> primeFactorization(int n) {
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
         * @param   n   Number to check the smallest Prime Factor for
         * @return      Smallest Prime Factor
         */
        private static int findLeastPrimeFactor(int n) { //
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
    }
}
