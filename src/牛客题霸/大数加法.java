package 牛客题霸;

import java.math.BigInteger;

/**
 * Created by xieli on 2021/3/12.
 */
public class 大数加法 {

    public String solve(String s, String t) {

        BigInteger bigInteger1 = new BigInteger(s);
        BigInteger bigInteger2 = new BigInteger(t);

        return bigInteger1.add(bigInteger2).toString();
    }

    public String solve_02(String s, String t) {
        if (s == null || s.equals(""))
            return t;
        if (t == null || t.equals(""))
            return s;

        int i = s.length() - 1;
        int j = t.length() - 1;
        int m1 = 0, m2 = 0, carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {

            if (i >= 0)
                m1 = s.charAt(i) - '0';
            else
                m1 = 0;

            if (j >= 0)
                m2 = t.charAt(j) - '0';
            else
                m2 = 0;

            int sum = m1 + m2 + carry;
            carry = sum / 10;
            sb.append((char) ((sum % 10) + '0'));
            i--;
            j--;
        }

        if (carry != 0)
            sb.append('1');

        return sb.reverse().toString();
    }

}
