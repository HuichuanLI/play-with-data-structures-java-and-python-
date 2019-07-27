

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

public class HashTable<K, V> {

    private TreeMap<K, V>[] hashtable;
    private int M;
    private int size;
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;


    public HashTable(int m) {
        this.M = m;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(97);
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
        if (size >= upperTol * M) {
            resize(2 * M);
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
            if (size < lowerTol * M && M >= initCapacity) {
                resize(M / 2);
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
