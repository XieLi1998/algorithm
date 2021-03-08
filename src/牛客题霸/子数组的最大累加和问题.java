package 牛客题霸;

/**
 * Created by xieli on 2021/3/8.
 */
public class 子数组的最大累加和问题 {

    public int maxSumOfSubarray(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(0, dp[i - 1] + arr[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
