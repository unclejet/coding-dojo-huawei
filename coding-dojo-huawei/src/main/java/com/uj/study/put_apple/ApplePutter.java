package com.uj.study.put_apple;

public class ApplePutter {

    /**
     * 算法思路笔记：
     * 1、通过苹果和盘子由少到多找互动关系的穷举法，尝试了多次后，无法驱动出一般算法；
     * 2、此时，必须换个思路，需要找到新的属性和互动关系动词，但是凭借自己的能力没有找到；如果是结对编程，可以依靠群体的力量可能发现新的建模线索；
     * 3、参考其他人的算法，总体思路还是由简到难，互动关系体现放苹果这个动词，属性是苹果和盘子的数量以及相互间的数量关系；
     * 4、m=0个苹果，n=1个盘子，因为没得放，所以放法=0；
     * 5、m=1,n=1: 只有一种放法，f(m,n)=1;
     * 6、m=1,n=2: f(m,n)=1;
     * 7、m=2,n=3: f(m,n)=2;由此推断出，当苹果数小于盘子数时,放法就是苹果数量，f(m,n)=m;
     * 8、m=2,n=2: a.先将苹果每个盘子放1个，是一种放法；b.一个盘子空着，将所有苹果放到其余盘子里是另一种放法，f(m,n)=1 + f(m, n-1);
     * 9、m=3,n=2： a.这一步是顿悟点，自己想不到：先把每个盘子放慢一个苹果，剩下的苹果放到n个盘子里=f(m-n, n);b.一个盘子空着，将所有苹果放到其余盘子里是另一种放法：f(m, n-1)，即f(m,n)=f(m-n, n) + f(m, n-1);
     *
     * @param apple
     * @param plate
     * @return
     */
    public static int possible(int apple, int plate) {
        if (apple > 0) {
            if (apple == 1 || plate == 1)
                return 1;
            else if (apple < plate)
                return apple;
            else if (apple == plate)
                return 1 + possible(apple, plate - 1);
            else if (apple > plate)
                return possible(apple - plate, plate) + possible(apple, plate - 1);
        }
        return 0;
    }
}