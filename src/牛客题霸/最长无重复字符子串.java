package 牛客题霸;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xieli on 2021/3/8.
 */
public class 最长无重复字符子串 {

    public int maxLength(int[] arr) {
        int left = 0, right = 0;
        Map<Integer, Integer> windows = new HashMap<>();
        int res = 0;

        while (right < arr.length) {
            int c = arr[right];
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            right++;

            while (windows.get(c) > 1) {
                int c1 = arr[left];
                windows.put(c1, windows.get(c1) - 1);
                left++;
            }

            res = Math.max(res, right - left);
        }

        return res;
    }

}
