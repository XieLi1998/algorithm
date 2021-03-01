package 剑指offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xieli on 2021/2/27.
 */
public class 最小的k个数 {

    // 大根堆，时间复杂度：O(NlogK)
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        // 默认是小根堆，实现大根堆需要重写一下比较器
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (pq.peek() > num) {
                pq.poll();
                pq.offer(num);
            }
        }

        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }

        return res;
    }

    // 快排
//    public int[] getLeastNumbers_02(int[] arr, int k) {
//
//    }

}
