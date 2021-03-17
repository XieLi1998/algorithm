package 牛客题霸;

/**
 * Created by xieli on 2021/3/17.
 */
public class 在转动过的有序数组中寻找目标值 {

    public int search(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target)
                return mid;
            if (A[mid] >= A[0]) {
                // 左侧有序
                if (A[mid] > target && A[left] <= target)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                // 右侧有序
                if (A[mid] < target && A[right] >= target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1;
    }

}
