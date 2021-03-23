package leetcode;

/**
 * Created by xieli on 2021/3/23.
 */
public class _260_只出现一次的数字III {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int mask = xor & (-xor);

        int[] res = new int[2];
        for (int num : nums) {
            if ((num & mask) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return res;
    }

}
