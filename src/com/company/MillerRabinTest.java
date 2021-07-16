package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;

public class MillerRabinTest {
    @Test
    public  void shoudFindKandQ(){
        BigInteger num= BigInteger.valueOf(53);
        ArrayList kAndQ= MillerRabin.generateKandQ(num);
        int k= (int) kAndQ.get(0);
        BigInteger q= (BigInteger) kAndQ.get(1);
        ensureBigIntsEqual(q,BigInteger.valueOf(13));

    }
    @Test
    public  void shouldGenerateBigIntInTheRange(){
        BigInteger lowerLimit= BigInteger.valueOf(20);
        BigInteger upperLimit= BigInteger.valueOf(50);
        BigInteger generated= MillerRabin.generateBigIntIntheRange(lowerLimit,upperLimit);
        assertTrue(ensureGreaterThanOrEqual(generated, lowerLimit));
        assertTrue(ensureLessThanOrEqual(generated,upperLimit));
    }

    private boolean ensureGreaterThanOrEqual(BigInteger greater, BigInteger less) {
        return greater.compareTo(less) >= 0;
    }
    private boolean ensureLessThanOrEqual(BigInteger less, BigInteger greater) {
        return less.compareTo(greater)<=0;
    }
    private void ensureBigIntsEqual( BigInteger expected, BigInteger actual){
        Assertions.assertTrue(expected.equals(actual));
    }
    private void assertTrue(boolean predicate){
        Assertions.assertTrue(predicate);
    }



}
