public class HashMapObj<K,V> {
    private final Integer hash;
    private final K key;
    private V value;

    public HashMapObj(Integer hash,K key, V value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public Integer getHash() {
        return hash;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HashMapObj{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
