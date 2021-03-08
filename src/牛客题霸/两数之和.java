package 牛客题霸;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xieli on 2021/3/8.
 */
public class 两数之和 {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return null;
    }

}
