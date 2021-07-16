package com.rabinMiller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class MillerRabin {
    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger THREE = new BigInteger("3");


    public static ArrayList generateKandQ(BigInteger num) {
        int k;
        BigInteger q;
        q = num.subtract(ONE);
        k = 0;
        while (q.mod(TWO).equals(ZERO)) {
            k++;
            q = q.divide(TWO);
        }
        ArrayList kAndQ = new ArrayList();
        kAndQ.add(k);
        kAndQ.add(q);
        return kAndQ;
    }

    public static boolean isProbablePrime(BigInteger num, int iterations) {
        if (num.equals(ZERO))
            return false;
        if (num.compareTo(THREE) < 0)
            return true;
        //the algorithm would still work with even numbers but to improve speed , even number are
        //filtered out.
        if (num.mod(TWO).equals(ZERO))
            return false;

        int k;
        BigInteger q;
        //find k and q such that num = 2^k * q
        ArrayList answers = generateKandQ(num);
        k = (int) answers.get(0);
        q = (BigInteger) answers.get(1);
        return checkIfPrime(num, iterations, k, q);
    }

    public static boolean checkIfPrime(BigInteger num, int iterations, int k, BigInteger q) {

        for (int i = 0; i < iterations; i++) {
            BigInteger numMinus1 = num.subtract(ONE);

            //generate number in the range [2, num-1]
            BigInteger base = generateBigIntIntheRange(TWO, numMinus1);

            //x=b^q mod num
            BigInteger x = base.modPow(q, num);
            if (x.equals(ONE) || x.equals(numMinus1))
                continue;

            int r = 0;
            while (r < k) {
                x = x.modPow(TWO, num);
                if (x.equals(ONE))
                    return false;
                if (x.equals(numMinus1))
                    break;
                r++;
            }
            if (r == k) // None of the steps made x equal n-1.
                return false;
        }
        return true;
    }

    public static BigInteger generateBigIntIntheRange(BigInteger lowerLimit, BigInteger upperLimit) {
        Random rnd = new Random();
        BigInteger res;
        do {

            res = new BigInteger(upperLimit.bitLength(), rnd);
        } while (res.compareTo(lowerLimit) < 0 || res.compareTo(upperLimit) > 0);
        return res;
    }
}
