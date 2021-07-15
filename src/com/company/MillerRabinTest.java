package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class MillerRabinTest {
    @Test
    public  void shouldFindKandM(){
        BigInteger prime=  BigInteger.valueOf(53);
        BigInteger expectedK= BigInteger.TWO;
        BigInteger expectedM= BigInteger.valueOf(13);
        MillerRabin mr= new MillerRabin(prime);
        mr.findKandM();
        Assertions.assertEquals(expectedK,mr.getK());
        Assertions.assertEquals(expectedM,mr.getM());
    }
}
