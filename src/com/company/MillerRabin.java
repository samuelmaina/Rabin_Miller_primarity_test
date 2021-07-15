package com.company;

import java.math.BigInteger;

public class MillerRabin {
    private BigInteger k=BigInteger.ZERO;
    private BigInteger m;
    private BigInteger prime;

    public void setK(BigInteger k) {
        this.k = k;
    }

    public void setM(BigInteger m) {
        this.m = m;
    }

    public BigInteger getK() {
        return k;
    }

    public BigInteger getM() {
        return m;
    }

    public MillerRabin(BigInteger prime) {
        this.prime = prime;
    }

    public void findKandM() {
        BigInteger two = BigInteger.TWO;
        BigInteger one= BigInteger.ONE;
        BigInteger s = prime.subtract(BigInteger.ONE);
        while (s.mod(two).equals(BigInteger.ZERO)) {
            s = s.divide(two);
            k=k.add(one);
        }
        m=s;
    }
}
