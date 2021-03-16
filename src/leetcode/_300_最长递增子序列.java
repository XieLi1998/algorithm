package leetcode;

import java.util.Arrays;

/**
 * Created by xieli on 2021/3/16.
 */
public class _300_最长递增子序列 {

    /**
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }


    public int lengthOfLIS_02(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;

        for (int num : nums) {
            if (res == 0 || num > tails[res - 1]) {
                tails[res++] = num;
            } else {
                int i = 0, j = res;
                while (i < j) {
                    int mid = (i + j) / 2;
                    if (tails[mid] < num)
                        i = mid + 1;
                    else
                        j = mid;
                }
                tails[i] = num;
            }
        }
        return res;
    }

}
