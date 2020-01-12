package com.uj.study.prime.factors;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * 算法参见
 * https://www.shuxuele.com/prime-factorization.html
 */
public class PrimeFactorTest {
    @Test
    void calculatePrimeListWithinInputNumber() {
        int input = 2;
        List<Long> primes = PrimeFactor.getPrimeList(input);
        assertThat(primes.size(), is(1));
        assertThat(primes.get(0), is(2L));

        primes = PrimeFactor.getPrimeList(3L);
        assertThat(primes.size(), is(2));

        primes = PrimeFactor.getPrimeList(4L);
        assertThat(primes.size(), is(2));

        primes = PrimeFactor.getPrimeList(5L);
        assertThat(primes.size(), is(3));

        primes = PrimeFactor.getPrimeList(180L);
        assertThat(primes.size(), is(41));
    }

    @Test
    void calcualtePrimeFactor() {
        assertThat(PrimeFactor.getPrimeFactor(12), is(Arrays.asList(2L, 2L, 3L)));
        assertThat(PrimeFactor.getPrimeFactor(147), is(Arrays.asList(3L, 7L ,7L)));
        assertThat(PrimeFactor.getPrimeFactor(17), is(Arrays.asList(17L)));
        assertThat(PrimeFactor.getPrimeFactor(180), is(Arrays.asList(2L, 2L, 3L, 3L, 5L)));
    }

    public void test3(int n){
        long start = System.currentTimeMillis();    //取开始时间
        int num=0;
        int j;
        boolean sgin;
        for (int i = 2; i <= n; i++) {
            if(i % 2 == 0 && i != 2  )  continue; //偶数和1排除

            sgin= true;
            for (j = 2; j <= Math.sqrt(i) ; j++) {
                if (i % j == 0) {
                    sgin = false;
                    break;
                }
            }

            //打印
            if (sgin) {
                num++;
                /* System.out.println(""+i);*/
            }
        }
        System.out.println(n+"以内的素数有"+num+"个");
        long end = System.currentTimeMillis();
        System.out.println("The time cost is " + (end - start));
        System.out.println("");
    }
}


