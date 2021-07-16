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
        Assertions.assertEquals(2,k);
        Assertions.assertEquals(BigInteger.valueOf(13),q);

    }



}
