package 牛客题霸;

/**
 * Created by xieli on 2021/3/21.
 */
public class 最长回文子串 {

    public int getLongestPalindrome(String s, int n) {
        // 如果字符串长度小于2，则直接返回其本身
        if (s.length() < 2) {
            return s.length();
        }

        String res = "";
        for (int i = 0; i < s.length() - 1; i++) {
            // 以 s.charAt(i) 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s.charAt(i) 和 s.charAt(i+1) 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);

            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }

        return res.length();
    }

    public String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

}
