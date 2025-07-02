package Basic;
import java.util.LinkedList;
import java.util.List;

public class MyChainingHashMap<K, V> {

    // 拉链法使用的单链表节点，存储 key-value 对
    private static class KVNode<K, V> {
        K key;
        V value;
        // 因为我们使用了内置的 LinkedList 类，所以不用 next 指针
        // 不用我们自己实现链表的逻辑

        KVNode(K key, V val) {
            this.key = key;
            this.value = val;
        }
    }

    // 哈希表的底层数组，每个数组元素是一个链表，链表中每个节点是 KVNode 存储键值对
    private LinkedList<KVNode<K, V>>[] table;

    // 哈希表中存入的键值对个数
    private int size;
    // 底层数组的初始容量
    private static final int INIT_CAP = 4;

    public MyChainingHashMap() {
        this(INIT_CAP);
    }

    public MyChainingHashMap(int initCapacity) {
        size = 0;
        // 保证底层数组的容量至少为 1，因为 hash 函数中有求余运算，避免出现除以 0 的情况
        initCapacity = Math.max(initCapacity, 1);
        // 初始化哈希表
        table = (LinkedList<KVNode<K, V>>[]) new LinkedList[initCapacity];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // **** 增/改 ****

    // 添加 key -> val 键值对
    // 如果键 key 已存在，则将值修改为 val
    public void put(K key, V val) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        // 如果 key 之前存在，则修改对应的 val
        for (KVNode<K, V> node : list) {
            if (node.key.equals(key)) {
                node.value = val;
                return;
            }
        }
        // 如果 key 之前不存在，则插入，size 增加
        list.add(new KVNode<>(key, val));
        size++;

        // 如果元素数量超过了负载因子，进行扩容
        if (size >= table.length * 0.75) {
            resize(table.length * 2);
        }
    }

    // **** 删 ****

    // 删除 key 和对应的 val
    public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        // 如果 key 存在，则删除，size 减少
        for (KVNode<K, V> node : list) {
            if (node.key.equals(key)) {
                list.remove(node);
                size--;

                // 缩容，当负载因子小于 0.125 时，缩容
                if (size <= table.length / 8) {
                    resize(table.length / 4);
                }
                return;
            }
        }
    }

    // **** 查 ****

    // 返回 key 对应的 val，如果 key 不存在，则返回 null
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        for (KVNode<K, V> node : list) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    // 返回所有 key
    public List<K> keys() {
        List<K> keys = new LinkedList<>();
        for (LinkedList<KVNode<K, V>> list : table) {
            for (KVNode<K, V> node : list) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    // **** 其他工具函数 ****

    public int size() {
        return size;
    }

    // 哈希函数，将键映射到 table 的索引
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % table.length;
    }

    private void resize(int newCap) {
        // 构造一个新的 HashMap
        // 避免 newCap 为 0，造成求模运算产生除以 0 的异常
        newCap = Math.max(newCap, 1);
        MyChainingHashMap<K, V> newMap = new MyChainingHashMap<>(newCap);
        // 穷举当前 HashMap 中的所有键值对
        for (LinkedList<KVNode<K, V>> list : table) {
            for (KVNode<K, V> node : list) {
                // 将键值对转移到新的 HashMap 中
                newMap.put(node.key, node.value);
            }
        }
        // 将当前 HashMap 的底层 table 换掉
        this.table = newMap.table;
    }

    public static void main(String[] args) {
        MyChainingHashMap<Integer, Integer> map = new MyChainingHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println(map.get(1)); // 1
        System.out.println(map.get(2)); // 2

        map.put(1, 100);
        System.out.println(map.get(1)); // 100

        map.remove(2);
        System.out.println(map.get(2)); // null
        // [1, 3]（顺序可能不同）
        System.out.println(map.keys());

        map.remove(1);
        map.remove(2);
        map.remove(3);
        System.out.println(map.get(1)); // null
    }
}