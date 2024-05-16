// --== CS400 Project One File Header ==--
// Name: Nisitha de silva
// CSL Username: nisitha
// Email: ntdesilva@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: <>

import java.security.Key;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Objects;

public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
    protected LinkedList<KNode<KeyType, ValueType>>[] map;

    /**
     *
     * @param capacity
     */
    public HashtableMap(int capacity) {

        map = new LinkedList[capacity];
        int i = 0;
        while (i != capacity) {
            map[i] = new LinkedList<KNode<KeyType, ValueType>>();
            i++;
        }
    }

    /**
     *
     */
    public HashtableMap() {// with default capacity = 15
        map = new LinkedList[15];
        int i = 0;
        while (i < 15) {
            map[i] = new LinkedList<KNode<KeyType, ValueType>>();
            i++;
        }

    }
    //Helper methods using KNode to reHash when the list exceeds the size by doubling the current
    // size and adding the data on it
    private LinkedList<KNode<KeyType, ValueType>>[] reHash() {
        LinkedList<KNode<KeyType, ValueType>>[] reMap = new LinkedList[(map.length * 2)];
        int i = 0;
        int j = 0;
        while (i < (map.length * 2)) {
            reMap[i] = new LinkedList<KNode<KeyType, ValueType>>();
            i++;
        }
        while(j < map.length){
            for (int k = 0; k < map[j].size(); k++) {
                reMap[j].addLast((KNode<KeyType, ValueType>) map[j].get(k));
            }
            j++;
        }
        map = reMap;
        return map ;

    }


    /**
     * Inserts a new (key, value) pair into the map if the map does not
     * contain a value mapped to key yet.
     *
     * @param key the key of the (key, value) pair to store
     * @param value the value that the key will map to
     * @return true if the (key, value) pair was inserted into the map,
     *         false if a mapping for key already exists and the
     *         new (key, value) pair could not be inserted
     */
    @Override public boolean put(KeyType key, ValueType value) {
        if (key == null || containsKey(key)) {
            return false;
        }
        int list = (Math.abs(key.hashCode())) % map.length;
        KNode<KeyType, ValueType> nNode = new KNode(key, value);


        map[list].add(nNode);
        double val = (size() / map.length);
        if (val >= 0.7) {
            reHash();
        }
        return true;
    }

    /**
     * Returns the value mapped to a key if the map contains such a mapping.
     *
     * @param key the key for which to look up the value
     * @return the value mapped to the key
     * @throws NoSuchElementException if the map does not contain a mapping
     *                                for the key
     */
    @Override public ValueType get(KeyType key) throws NoSuchElementException {
        if (!(containsKey(key))) {
            throw new NoSuchElementException("No key value");
        }
        int i = 0;
        int j;
        while (i < map.length) {
            for (j = 0; j < map[i].size(); j++) {
                KNode<KeyType, ValueType> value = (KNode<KeyType, ValueType>) map[i].get(j);
                KeyType current = value.getKey();

                if (Objects.equals(current, key)) {
                    ValueType val = value.getValue();
                    return val;
                }
            }
            i++;
        }
        return null;
    }

    /**
     * Removes a key and its value from the map.
     *
     * @param key the key for the (key, value) pair to remove
     * @return the value for the (key, value) pair that was removed,
     *         or null if the map did not contain a mapping for key
     */
    @Override public ValueType remove(KeyType key) {
        if (!(containsKey(key))) {
           return null;
        }
        int i = 0;
        int j = 0;
        ValueType val = null;
        while (i < map.length) {
            for (j = 0; j < map[i].size(); j++) {
                KNode<KeyType, ValueType> keys = (KNode<KeyType, ValueType>) map[i].get(j);
                KeyType current = keys.getKey();

                if (Objects.equals(current, key)) {
                    val = keys.getValue();
                    map[i].remove(j);
                }
            }
            i++;
        }
        return val;
    }

    /**
     * Checks if a key is stored in the map.
     *
     * @param key the key to check for
     * @return true if the key is stored (mapped to a value) by the map
     *         and false otherwise
     */
    @Override public boolean containsKey(Object key) {
        int i = 0;
        int j = 0;
        ValueType val = null;
        while (i < map.length) {
            if (map[i] != null) {
                for (j = 0; j < map[i].size(); j++) {
                    KNode<KeyType, ValueType> keys = (KNode<KeyType, ValueType>) map[i].get(j);
                    KeyType current = keys.getKey();
                    if (Objects.equals(current, key)) {
                        return true;
                    }
                }
            }
            i++;
        }
        return false;
    }

    /**
     * Returns the number of (key, value) pairs stored in the map.
     *
     * @return the number of (key, value) pairs stored in the map
     */
    @Override public int size() {
        int size = 0;
        int i = 0;

        while (i < map.length) {
            if (map[i] != null) {
                size = size + map[i].size();
            }
            i++;
        }
        return size;
    }
    /**
     * Removes all (key, value) pairs from the map.
     */
    @Override public void clear() {
       int i = 0;
       while(i < map.length){
           for (int j = 0; j < map[i].size(); j++) {
                    map[i].clear();
                }
           i++;
            }

        }
    }
