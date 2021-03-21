package leetcode;

/**
 * Created by xieli on 2021/3/21.
 */
public class _647_回文子串 {

    public int countSubstrings(String s) {
        int res = 0;

        // 注意，此题必须取到最后一位，因为此题并不是求最长回文子串，而是问有多少个回文子串
        for (int i = 0; i < s.length(); i++) {
            res += palindrome(s, i, i);
            res += palindrome(s, i, i + 1);
        }
        return res;
    }

    public int palindrome(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }

        return count;
    }

}
