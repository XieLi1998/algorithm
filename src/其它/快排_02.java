package 其它;

import java.util.Random;

/**
 * Created by xieli on 2021/3/5.
 */
public class 快排_02 {

    // 2. 双指针(指针对撞)快速排序

    private static final int INSERTION_SORT_THRESHOLD = 7;

    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        // 小区间使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
    }

    // 对数组 nums 的子区间 [left, right] 使用插入排序
    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);

        // 基准值
        int pivot = nums[left];
        // lt 是 less than 的缩写，表示（严格）小于；
        // gt 是 greater than 的缩写，表示（严格）大于；
        int lt = left + 1;
        int gt = right;

        // all in [left + 1, lt) <= pivot
        // all in (gt, right) >= pivot
        while (true) {
            while (lt <= right && nums[lt] < pivot) {
                lt++;
            }

            while (gt > left && nums[gt] > pivot) {
                gt--;
            }

            if (lt >= gt) {
                break;
            }

            swap(nums, lt, gt);
            lt++;
            gt--;
        }

        swap(nums, left, gt);
        return gt;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
