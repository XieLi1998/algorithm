package 笔试;

/**
 * Created by xieli on 2021/4/8.
 */
public class 微步在线 {

    public int indexOf(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
//        for (int i = 0; i <= N - M; i++) {
//            int j;
//            for (j = 0; j < N; j++) {
//                if (pat.charAt(j) != txt.charAt(i + j))
//                    break;
//            }
//            if (j == M)
//                return i;
//        }
//
//        return -1;
        int[][] dp = new int[M][256];
        dp[0][pat.charAt(0)] = 1;
        int X = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 256; j++) {
                dp[i][j] = dp[X][j];
            }
            dp[i][pat.charAt(i)] = i + 1;
            X = dp[X][pat.charAt(i)];
        }

        int j = 0;
        for (int i = 0; i < N; i++) {
            j = dp[j][txt.charAt(i)];
            if (j == M)
                return i - M + 1;
        }

        return -1;
    }

}
