package 牛客题霸;

/**
 * Created by xieli on 2021/3/14.
 */
public class 反转字符串 {

    public String solve(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        return new StringBuilder(str).reverse().toString();
    }

    public String solve_02(String str) {
        char[] chars = str.toCharArray();
        char[] res = new char[chars.length];
        int idx = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            res[idx++] = chars[i];
        }
//        return new String(res);
        return String.valueOf(res);
    }

}
