package 牛客题霸;

/**
 * 此题联动 leetcode 最长公共子序列
 *
 * https://blog.nowcoder.net/n/79212635b5c8478fa5131644ffe2a0b9
 *
 * Created by xieli on 2021/3/11.
 */
public class 最长公共子串 {

    public String LCS(String str1, String str2) {

        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        int maxLen = 0, end = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = str1.charAt(i), c2 = str2.charAt(j);
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = 0;
                }

                if (dp[i + 1][j + 1] > maxLen) {
                    maxLen = dp[i + 1][j + 1];
                    end = j + 1;
                }
            }
        }

        String res = str2.substring(end - maxLen, end);

        return res;
    }

}
