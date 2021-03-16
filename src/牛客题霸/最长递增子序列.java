package 牛客题霸;

/**
 * Created by xieli on 2021/3/16.
 */
public class 最长递增子序列 {

    public int[] LIS(int[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        int len = arr.length;
        int[] count = new int[len];
        int[] end = new int[len];       // 存最长递增子序列

        int index = 0;
        end[index] = arr[0];

        for (int i = 0; i < len; i++) {
            if (end[index] < arr[i]) {
                end[++index] = arr[i];
                count[i] = index;
            } else {
                int left = 0, right = index;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (end[mid] >= arr[i])
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
                end[left] = arr[i];
                count[i] = left;
            }
        }

        int[] res = new int[index + 1];
        for (int i = len - 1; i >= 0; i--) {
            if (count[i] == index)
                res[index--] = arr[i];
        }

        return res;
    }

}
