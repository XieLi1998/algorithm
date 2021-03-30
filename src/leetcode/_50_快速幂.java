package leetcode;

/**
 * Created by xieli on 2021/3/30.
 */
public class _50_快速幂 {

    public double myPow(double x, int n) {
        if (x == 0.0f)
            return 0.0d;

        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b > 0) {
            if ((b & 1) == 1)
                res *= x;
            x *= x;
            b >>= 1;
        }

        return res;
    }

}
