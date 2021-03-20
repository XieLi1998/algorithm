package 牛客题霸;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by xieli on 2021/3/19.
 */
public class 数组中相加和为0的三元组 {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (num == null || num.length == 0) {
            return res;
        }

        Arrays.sort(num);       // 排序

        for (int i = 0; i < num.length - 2; i++) {
            if (num[i] > 0) {
                break;          // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            }

            if (i > 0 && num[i] == num[i - 1]) {
                continue;       // 去重
            }

            int L = i + 1;
            int R = num.length - 1;

            while (L < R) {
                int sum = num[i] + num[L] + num[R];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[L]);
                    list.add(num[R]);

                    res.add(list);

                    while (L < R && num[L] == num[L + 1]) {
                        L++;
                    }
                    while (L < R && num[R] == num[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else if (sum < 0) {
                    L++;
                }
            }
        }
        return res;
    }

}
