package 牛客题霸;

/**
 * Created by xieli on 2021/3/23.
 */
public class 进制转换 {

    /**
     * 算法思路： 除N取余，然后倒序排列，高位补零。
     * @param M
     * @param N
     * @return
     */
    public String solve(int M, int N) {

        if (M == 0)
            return "0";

        String s = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (M < 0) {
            flag = true;
            M = -M;
        }

        while (M != 0) {
            sb.append(s.charAt(M % N));
            M /= N;
        }

        if (flag) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }

}
