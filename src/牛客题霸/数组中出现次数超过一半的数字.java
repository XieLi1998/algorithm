package 牛客题霸;

/**
 * Created by xieli on 2021/3/31.
 */
public class 数组中出现次数超过一半的数字 {

    public int MoreThanHalfNum_Solution(int[] array) {
        int x = 0, votes = 0;
        for (int num : array) {
            if (votes == 0)
                x = num;
            votes += num == x ? 1 : -1;
        }

        int count = 0;
        for (int num : array) {
            if (num == x)
                count++;
        }
        return count > array.length / 2 ? x : 0;
    }

    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0)
                x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

}
