package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class MillerRabin {
    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger THREE = new BigInteger("3");


    public static ArrayList generateKandQ(BigInteger num){
        int k;
        BigInteger q;
        q = num.subtract(ONE);
        k = 0;
        while (q.mod(TWO).equals(ZERO)) {
            k++;
            q = q.divide(TWO);
        }
        ArrayList kAndQ= new ArrayList();
        kAndQ.add(k);
        kAndQ.add(q);
        return kAndQ;
    }


}
