package 牛客题霸;

/**
 * Created by xieli on 2021/3/21.
 */
public class 斐波拉契数列 {

    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public int Fibonacci_02(int n) {
        if (n == 0)
            return 0;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int Fibonacci_03(int n) {
        int a = 0, b = 1, sum;

        for (int i = 0; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return a;
    }

}
