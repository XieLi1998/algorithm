package 牛客题霸;

/**
 * Created by xieli on 2021/2/25.
 */
public class 二分查找 {

    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_(int n, int v, int[] a) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] < v) {
                left = mid + 1;
            } else if (a[mid] > v) {
                right = mid - 1;
            } else if (a[mid] == v) {
                right = mid - 1;
            }
        }
        // 检查 left 越界情况
        // if (left >= a.length || a[left] != v)
        // 注意，牛客题霸里可能存在没有这个值，但是依然存在要找第一个大于给定值的位置
        if (left >= a.length)
            return n + 1;
        return left + 1;
    }

}
