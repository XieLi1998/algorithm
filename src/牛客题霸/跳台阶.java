package 牛客题霸;

/**
 * Created by xieli on 2021/3/8.
 */
public class 跳台阶 {

    // 递归
    public int jumpFloor(int target) {
        if (target <= 1) {
            return 1;
        }
        if (target < 3) {
            return target;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    // 非递归
    public int jumpFloor_II(int target) {
        if (target <= 1) {
            return 1;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

}
