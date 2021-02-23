package leetcode;

import java.util.HashMap;

/**
 * Created by xieli on 2021/2/23.
 */
public class _146_LRU缓存机制 {

    // 哈希表查找快，但是数据无固定顺序；链表有顺序之分，插入删除快，但是查找慢。
    // 所以结合一下，形成一种新的数据结构：哈希链表。
    class LRUCache {

        class Node {
            public int key, val;
            public Node next, prev;

            public Node(int k, int v) {
                this.key = k;
                this.val = v;
            }
        }

        // 双链表
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
