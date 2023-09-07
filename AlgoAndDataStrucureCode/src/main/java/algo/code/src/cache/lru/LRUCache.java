package algo.code.src.cache.lru;

import java.util.HashMap;

/** LRU 算法 超过缓存限制，删除最近最久未使用 */
public class LRUCache {

    // cache 中存的双链表 ，前后指针的改变会随着get 出来以后改变
    public HashMap<Integer, DoubleLinkedList> cache = new HashMap<>();
    public Integer cacheSize;
    public Integer size = 0;
    // 链表的头尾前后指针  head 头前， tail 尾后
    DoubleLinkedList head;
    DoubleLinkedList tail;

    public LRUCache(int capacity) {
        cacheSize = capacity;

        head = new DoubleLinkedList();
        tail = new DoubleLinkedList();
        head.next = tail;
        tail.last = head;
    }

    public Integer get(int key) {
        DoubleLinkedList value = cache.get(key);
        if (value == null) {
            return -1;
        }
        moveToHead(value);
        return value.value;
    }

    public void put(int key, int value) {
        DoubleLinkedList doubleLinkedList = cache.get(key);
        if (doubleLinkedList == null) {
            doubleLinkedList = new DoubleLinkedList(key, value);
            addHead(doubleLinkedList);

            cache.put(key, doubleLinkedList);
            size++;
            if (size > cacheSize) {
                DoubleLinkedList removeTail = removeTail();
                cache.remove(removeTail.key);
                size--;
            }
        } else {
            doubleLinkedList.value = value;
            moveToHead(doubleLinkedList);
        }
    }

    /*
       先删除这个节点
       在添加到 链表头部
    */
    private void moveToHead(DoubleLinkedList value) {
        removeNode(value);
        addHead(value);
    }

    private void addHead(DoubleLinkedList value) {
        value.last = head;
        value.next = head.next;
        head.next.last = value;
        head.next = value;
    }

    private void removeNode(DoubleLinkedList value) {
        if (value.last != null) {
            value.last.next = value.next;
        }

        if (value.next != null) {
            value.next.last = value.last;
        }
    }

    private DoubleLinkedList removeTail() {
        DoubleLinkedList last = tail.last;
        removeNode(last);
        return last;
    }
}

class DoubleLinkedList {
    public int key;
    public int value;
    public DoubleLinkedList last;
    public DoubleLinkedList next;

    public DoubleLinkedList() {}

    public DoubleLinkedList(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
