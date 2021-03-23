package 牛客题霸;

/**
 * Created by xieli on 2021/3/23.
 */
public class 容器盛水 {

    public long maxWater(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return 0;
        }

        int left = 0, right = arr.length - 1;
        long sum = 0;
        // 找出左右边界的最小值作为水位高度
        int mark = Math.min(arr[left], arr[right]);

        while (left < right) {
            // 如果左边较低，则左边界向右遍历， 否则右边界向左移动
            if (arr[left] < arr[right]) {
                left++;
                // 如果当前标尺小于水位，则水量累加
                if (mark > arr[left]) {
                    sum += mark - arr[left];
                } else {
                    // 否则，将此标尺和右边边界高度进行比较，找出剩下数组中的新水位
                    mark = Math.min(arr[left], arr[right]);
                }
            } else {
                right--;
                // 同理，如果当前标尺小于水位，则水量累加
                if (mark > arr[right]) {
                    sum += mark - arr[right];
                } else {
                    mark = Math.min(arr[left], arr[right]);
                }
            }
        }

        return sum;
    }

}
