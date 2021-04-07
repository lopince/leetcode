package com.leetcode.solution;

import java.util.Arrays;

public class CountPrimes {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(10));
    }

    private static class Solution {

        public int countPrimes(int n) {

            if (n < 3) {
                return 0;
            }

            Boolean[] isPrimes = new Boolean[n];

            Arrays.fill(isPrimes, true);

            for (int i = 2; i * i < n; i++) {
                if (isPrimes[i]) {

                    // if 2 is primes then 2*2, 2*3 2*n is not primes
                    for (int j = i * i; j < n; j += i) {
                        isPrimes[j] = false;
                    }
                }
            }


            isPrimes[0] = false;
            isPrimes[1] = false;
            return (int)
                    (Arrays.stream(isPrimes)
                            .filter(prime -> prime)
                            .count());
        }
    }
}
