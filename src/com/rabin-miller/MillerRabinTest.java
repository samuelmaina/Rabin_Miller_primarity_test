package com.rabinMiller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;

public class MillerRabinTest {
    @Test
    public void shoudFindKandQ() {
        BigInteger num = BigInteger.valueOf(3);
        ArrayList kAndQ = MillerRabin.generateKandQ(num);
        int k = (int) kAndQ.get(0);
        BigInteger q = (BigInteger) kAndQ.get(1);
        ensureBigIntsEqual(q, BigInteger.valueOf(1));
        Assertions.assertEquals(k, 1);
        num = BigInteger.valueOf(53);
        kAndQ = MillerRabin.generateKandQ(num);
        k = (int) kAndQ.get(0);
        q = (BigInteger) kAndQ.get(1);
        ensureBigIntsEqual(q, BigInteger.valueOf(13));
        Assertions.assertEquals(k, 2);

    }

    @Test
    public void shouldGenerateBigIntInTheRange() {
        BigInteger lowerLimit = BigInteger.valueOf(20);
        BigInteger upperLimit = BigInteger.valueOf(50);
        BigInteger generated = MillerRabin.generateBigIntIntheRange(lowerLimit, upperLimit);
        assertTrue(ensureGreaterThanOrEqual(generated, lowerLimit));
        assertTrue(ensureLessThanOrEqual(generated, upperLimit));
    }

    @Test
    public void runPrimarityShouldReturnTrueForPrimeNumbers() {
        BigInteger bigPrime = BigInteger.valueOf(53);
        int iterations = 3;
        boolean isPrime = MillerRabin.checkIfPrime(bigPrime, iterations, 2, BigInteger.valueOf(13));
        assertTrue(isPrime);
    }

    @Test
    public void runPrimarityShouldReturnFalseForNonPrimes() {
        BigInteger bigPrime = BigInteger.valueOf(9);
        int iterations = 3;
        // 8=9-1= 2^3*1;
        boolean isPrime = MillerRabin.checkIfPrime(bigPrime, iterations, 3, BigInteger.ONE);
        assertFalse(isPrime);
    }

    @Test
    public void isProbablyPrimeShouldReturnTrueForPrimeNumbers() {
        int iterations = 1;
        boolean isPrime = MillerRabin.isProbablePrime(BigInteger.TWO, iterations);
        assertTrue(isPrime);
        BigInteger intermediatePrime = new BigInteger("226673591177742970257407");
        iterations = 10;
        isPrime = MillerRabin.isProbablePrime(intermediatePrime, iterations);
        assertTrue(isPrime);
        BigInteger largePrime = (BigInteger.TWO.pow(521)).subtract(BigInteger.ONE);
        iterations = 64;
        isPrime = MillerRabin.isProbablePrime(largePrime, iterations);
        assertTrue(isPrime);
    }

    @Test
    public void isProbablyPrimeShouldReturnFalseForNonPrimes() {
        int iterations = 3;
        boolean isPrime = MillerRabin.isProbablePrime(BigInteger.valueOf(4), iterations);
        assertFalse(isPrime);
        BigInteger intermediateNum = new BigInteger("226673591177742970257405");
        iterations = 10;
        isPrime = MillerRabin.isProbablePrime(intermediateNum, iterations);
        assertFalse(isPrime);
        BigInteger largeNum = (BigInteger.TWO.pow(521));
        iterations = 64;
        isPrime = MillerRabin.isProbablePrime(largeNum, iterations);
        assertFalse(isPrime);
    }

    private boolean ensureGreaterThanOrEqual(BigInteger greater, BigInteger less) {
        return greater.compareTo(less) >= 0;
    }

    private boolean ensureLessThanOrEqual(BigInteger less, BigInteger greater) {
        return less.compareTo(greater) <= 0;
    }

    private void ensureBigIntsEqual(BigInteger expected, BigInteger actual) {
        Assertions.assertTrue(expected.equals(actual));
    }

    private void assertTrue(boolean predicate) {
        Assertions.assertTrue(predicate);
    }

    private void assertFalse(boolean predicate) {
        Assertions.assertFalse(predicate);
    }

}
