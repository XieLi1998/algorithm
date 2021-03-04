package 牛客题霸;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xieli on 2021/3/4.
 */
public class 寻找第K大 {

    // 注意第 K 大是倒着数的，最大的是排序后的最后一位
    public static int findKth(int[] a, int n, int K) {
        // write code here
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : a) {
            if (pq.size() < K) {
                pq.offer(num);
            } else if (pq.peek() < num) {
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
    }

}
