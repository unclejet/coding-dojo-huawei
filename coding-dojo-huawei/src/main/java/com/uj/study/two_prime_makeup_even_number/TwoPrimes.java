package com.uj.study.two_prime_makeup_even_number;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/11/1 下午12:38
 * @description：
 */
class TwoPrimes {
    private Integer prime1;
    private Integer prime2;

    public TwoPrimes(Integer prime1, Integer prime2) {
        this.prime1 = prime1;
        this.prime2 = prime2;
    }

    public void setPrime1(Integer prime1) {
        this.prime1 = prime1;
    }

    public void setPrime2(Integer prime2) {
        this.prime2 = prime2;
    }

    public Integer getPrime1() {
        return prime1;
    }

    public Integer getPrime2() {
        return prime2;
    }
}
