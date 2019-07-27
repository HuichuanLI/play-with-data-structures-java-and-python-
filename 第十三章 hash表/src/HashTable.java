

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

public class HashTable<K, V> {

    private TreeMap<K, V>[] hashtable;
    private int M;
    private int size;
    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private int CapacityIndex = 0;


    public HashTable() {
        this.M = capacity[CapacityIndex];
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }


    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {

        TreeMap<K, V> map = hashtable[hash(key)];
        if (hashtable[hash(key)].containsKey(key))
            map.put(key, value);
        else
            map.put(key, value);
        size++;
        if (size >= upperTol * M && CapacityIndex < capacity.length) {
            CapacityIndex++;
            resize(capacity[CapacityIndex]);
        }
    }

    public void resize(int newM) {
        TreeMap<K, V>[] newHashtable = new TreeMap[newM];
        for (int i = 0; i < newM; i++)
            newHashtable[i] = new TreeMap<>();
        int oldM = this.M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashtable[i];
            for (K key : map.keySet()) {
                newHashtable[hash(key)].put(key, map.get(key));
            }
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
            if (size < lowerTol * M && CapacityIndex > 0) {
                CapacityIndex--;
                resize(capacity[CapacityIndex]);
            }
        }

        return ret;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key))
            throw new IllegalArgumentException(key + "doesn't exist!");
        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }

}
