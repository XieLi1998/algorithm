package leetcode;

/**
 * Created by xieli on 2021/2/22.
 */
public class _912_排序数组 {

    /**
     * 选择排序：
     * 每一轮选择最小元素交换到未排定部分的开头
     */
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 循环不变量：[0, i) 有序，且该区间里所有元素就是最终排定的样子
        for (int i = 0; i < len - 1; i++) {
            // 选择区间 [i, len - 1] 里最小的元素的索引，交换到下标 i
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 插入排序：
     * 每次将一个数字插入一个有序的数组里，成为一个长度更长的有序数组，
     * 有限次操作以后，数组整体有序
     */
    // 插入排序：稳定排序，在接近有序的情况下，表现优异
    public int[] sortArray_02(int[] nums) {
        int len = nums.length;
        // 循环不变量：将 nums[i] 插入到区间 [0, i) 使之成为有序数组
        for (int i = 1; i < len; i++) {
            // 先暂存这个元素，然后之前元素逐个后移，留出空位
            int tmp = nums[i];
            int j = i;
            // 注意边界 j > 0
            while (j > 0 && nums[j - 1] > tmp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
        return nums;
    }

    /**
     * 归并排序：
     * 借助额外空间，合并两个有序数组，得到更长的有序数组
     */
    public int[] sortArray_03(int[] nums) {
        int len = nums.length;
        int[] tmp = new int[len];
        mergeSort(nums, 0, len - 1, tmp);
        return nums;
    }

    /**
     * 对数组 num 的子区间 [left, right] 进行排序
     *
     * @param nums
     * @param left
     * @param right
     * @param tmp   用于合并两个有序数组的辅助数组，全局使用一份，避免多次创建和销毁
     */
    private void mergeSort(int[] nums, int left, int right, int[] tmp) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        // Java 里有更优的写法，在 left 和 right 都是大整数时，即使溢出，结论依然正确
        // int mid = (left + right) >>> 1;

        mergeSort(nums, left, mid, tmp);
        mergeSort(nums, mid + 1, right, tmp);
        // 如果数组的这个子区间本身有序，无需合并
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }

        mergeOfTwoSortedArray(nums, left, mid, right, tmp);
    }

    /**
     * 合并两个有序数组：先把值复制到临时数组，再合并回去
     *
     * @param nums
     * @param left
     * @param mid   [left, mid] 有序，[mid + 1, right] 有序
     * @param right
     * @param tmp   全局使用的临时数组
     */
    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] tmp) {
        System.arraycopy(nums, left, tmp, left, right - left + 1);

        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = tmp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = tmp[i];
                i++;
            } else if (tmp[i] <= tmp[j]) {
                // 注意写成 < 就丢失了稳定性（相同元素原来靠前的排序以后依然靠前）
                nums[k] = tmp[i];
                i++;
            } else {
                // temp[i] > temp[j]
                nums[k] = tmp[j];
                j++;
            }
        }
    }

    /**
     * @param src     原数组
     * @param srcPos  从元数据的起始位置开始
     * @param dest    目标数组
     * @param destPos 目标数组的开始起始位置
     * @param length  要copy的数组的长度
     */
    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) {
    }


    /**
     * 快速排序
     *
     * 基本思路：快速排序每一次都排定一个元素（这个元素呆在了它最终应该呆的位置），然后递归地去排它左边的部分和右边的部分，
     * 依次进行下去，直到数组有序；
     *
     * 算法思想：分而治之（分治思想），与「归并排序」不同，「快速排序」在「分」这件事情上不想「归并排序」无脑地一分为二，
     * 而是采用了 partition 的方法（书上，和网上都有介绍，就不展开了），因此就没有「合」的过程。
     *
     * 实现细节（注意事项）：（针对特殊测试用例：顺序数组或者逆序数组）一定要随机化选择切分元素（pivot），
     * 否则在输入数组是有序数组或者是逆序数组的时候，快速排序会变得非常慢（等同于冒泡排序或者「选择排序」）；
     */
    public int[] sortArray_04(int[] nums) {
        return nums;
    }
}
