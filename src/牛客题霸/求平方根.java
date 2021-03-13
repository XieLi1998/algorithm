package 牛客题霸;

/**
 * Created by xieli on 2021/3/14.
 */
public class 求平方根 {

    public int sqrt(int x) {

        return (int) Math.sqrt(x);

    }

    /**
     * 根据平方数的性质——连续n个奇数相加的结果一定是平方数
     * <p>
     * 9=1+3+5；
     * 16=1+3+5+7；
     *
     * @param x
     * @return
     */
    public int sqrt_02(int x) {
        int i = 1;
        int count = 0;

        while (x >= 0) {
            x -= i;
            count++;
            i += 2;
        }

        return count - 1;
    }

    public int sqrt_03(int x) {
        if (x == 0)
            return 0;

        long left = 1, right = x / 2;

        while (left < right) {
            long mid = (left + right + 1) / 2;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return (int) left;
    }

}
