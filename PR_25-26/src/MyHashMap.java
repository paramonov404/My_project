import java.util.Iterator;
import java.util.ArrayList;

public class MyHashMap<K,V> implements HashMapInterface<K,V>, Iterable<V> {
    private final ArrayList<ArrayList<HashMapObj<K,V>>> newHashMap;
    private final int size = 20;

    public MyHashMap() {
        newHashMap = new ArrayList<>();
        for(int i=0;i<size;i++){
            newHashMap.add(new ArrayList<HashMapObj<K,V>>());
        }
    }

    @Override
    public void add(K key, V value) {
        int hash = key.hashCode();
        int index = (size - 1) & hash;
        if (newHashMap.get(index).size() > 0){
            boolean bool = true;
            for (int i=0; i<newHashMap.get(index).size();i++){
                if (key.equals(newHashMap.get(index).get(i).getKey())){
                    newHashMap.get(index).get(i).setValue(value);
                    bool = false;
                }
            }
            if(bool){
                newHashMap.get(index).add(new HashMapObj<>(hash,key,value));
            }
        }
        else{
            newHashMap.get(index).add(new HashMapObj<>(hash,key,value));
        }
    }

    @Override
    public V get(K key) {
        int hash = key.hashCode();
        int index = (size - 1) & hash;
        if (newHashMap.get(index).size() > 0) {
            for (int i = 0; i < newHashMap.get(index).size(); i++) {
                if (key.equals(newHashMap.get(index).get(i).getKey())) {
                    return newHashMap.get(index).get(i).getValue();
                }
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int hash = key.hashCode();
        int index = (size - 1) & hash;
        if (newHashMap.get(index).size() > 0) {
            for (int i = 0; i < newHashMap.get(index).size(); i++) {
                if (key.equals(newHashMap.get(index).get(i).getKey())) {
                    V value = newHashMap.get(index).get(i).getValue();
                    newHashMap.get(index).remove(i);
                    return value;
                }
            }
        }
        return null;
    }

    @Override
    public Iterator<V> iterator() {
        return (new Iterator<V>() {
            int currIndOfObj = 0, currIndOfBuk = 0;

            @Override
            public boolean hasNext() {
                if (currIndOfObj == newHashMap.get(currIndOfBuk).size()){
                    while(newHashMap.get(currIndOfBuk+1).size() == 0) {
                        currIndOfBuk++;
                        if (currIndOfBuk == size -1 )
                            return false;
                    }
                    if (currIndOfBuk == size -1 )
                        return false;
                    else {
                        currIndOfBuk++;
                        currIndOfObj = 0;
                    }
                }
                return (currIndOfBuk < newHashMap.size()) && (currIndOfObj < newHashMap.get(currIndOfBuk).size());
            }

            @Override
            public V next() {
                return newHashMap.get(currIndOfBuk).get(currIndOfObj++).getValue();
            }
        });
    }
}
