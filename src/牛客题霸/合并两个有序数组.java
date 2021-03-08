package 牛客题霸;

/**
 * Created by xieli on 2021/3/8.
 */
public class 合并两个有序数组 {

    public void merge(int A[], int m, int B[], int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len1 >= 0 && len2 >= 0) {
            A[len--] = A[len1] > B[len2] ? A[len1--] : B[len2--];
        }
        // 表示将 B 数组从下标 0 位置开始，拷贝到 A 数组中，从下标 0 位置开始，长度为len2+1
        System.arraycopy(B, 0, A, 0, len2 + 1);
    }

}
