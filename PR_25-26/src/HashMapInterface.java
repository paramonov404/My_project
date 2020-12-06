public interface HashMapInterface<K,V> extends Iterable<V> {
    void add(K key, V value);
    V get(K key);
    V remove(K key);
}