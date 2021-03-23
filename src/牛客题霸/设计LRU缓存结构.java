package 牛客题霸;

import leetcode._146_LRU缓存机制;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by xieli on 2021/2/23.
 */
public class 设计LRU缓存结构 {

    public int[] LRU(int[][] operators, int k) {
        LRUCache LRU = new LRUCache(k);
        int len = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] res = new int[len];
        for (int i = 0, j = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                LRU.put(operators[i][1], operators[i][2]);
            } else {
                res[j++] = LRU.get(operators[i][1]);
            }
        }
        return res;
    }

    class LRUCache {
        class Node {
            public int key, val;
            public Node next, prev;

            public Node(int k, int v) {
                this.key = k;
                this.val = v;
            }
        }

        // 双向链表
        class DoubleList {
            private Node head, tail;
            private int size;

            public void addFirst(Node node) {
                if (head == null) {
                    head = tail = node;
                } else {
                    head.prev = node;
                    node.next = head;
                    head = node;
                }
                size++;
            }

            public void remove(Node node) {
                if (head == node && tail == node) {
                    head = null;
                    tail = null;
                } else if (head == node) {
                    node.next.prev = null;
                    head = node.next;
                } else if (tail == node) {
                    node.prev.next = null;
                    tail = node.prev;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                size--;
            }

            public Node removeLast() {
                Node node = tail;
                remove(tail);
                return node;
            }

            public int size() {
                return size;
            }
        }

        private HashMap<Integer, Node> map;
        private DoubleList cache;
        private int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            cache = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;
            int value = map.get(key).val;
            // 利用 put 方法把该数据提前
            put(key, value);
            return value;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);

            if (map.containsKey(key)) {
                // 删除旧的节点，新的插到头部
                cache.remove(map.get(key));
                cache.addFirst(node);
                // 更新 map 中对应的数据
                map.put(key, node);
            } else {
                if (cap == cache.size) {
                    // 删除链表最后一个数据
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                // 直接添加到头部
                cache.addFirst(node);
                map.put(key, node);
            }
        }
    }

}
