package com.jxw.common;

import java.util.HashMap;

/**
 * 为了能够快速删除最久没有访问的数据项和插入最新的数据项，我们使用 双向链表 连接Cache中的数据项，并且保证链表维持数据项从最近访问到最旧访问的顺序。
 * 插入：当Cache未满时，新的数据项只需插到双链表头部即可。时间复杂度为O(1)O(1).
 * 替换：当Cache已满时，将新的数据项插到双链表头部，并删除双链表的尾结点即可。时间复杂度为O(1)O(1).
 * 查找：每次数据项被查询到时，都将此数据项移动到链表头部。
 * ————————————————
 */
public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    /**
     * 头结点
     */
    Node head = null;
    /**
     * 尾节点
     */
    Node end = null;

    /*初始化大小，缓存是有大小限制的，超过规定的大小时就得移除*/
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    //获取一个缓存数据之后，应该把这个数据在当前位置中移除，并重新添加到头的位置，这些都是在返回数据之前完成的
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }

        return -1;
    }

    //移除元素分为，N的前边和N的后边都要看是怎么样的情况
    public void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }

    }

    public void setHead(Node n) {
        n.next = head;//head原位置应该是指向第一个元素，现在把这个位置给n.next
        n.pre = null;

        if (head != null)
            head.pre = n;

        head = n;
        //判断头尾是够为空
        if (end == null)
            end = head;
    }

    //设置看原位置是否有元素，如果有的话就替换，这证明使用过了，然后将其替换为头结点的元素，若果是一个新的节点就要判断它的大小是否符合规范
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
            }
            setHead(created);

            map.put(key, created);
        }
    }
}

class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}