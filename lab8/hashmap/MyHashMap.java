package hashmap;

import java.util.*;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    /* Instance Variables */
    private Collection<Node>[] buckets;
    private int size;
    private double factor;
    private int initialSize;
    private Collection<Node>[] backArray;
    // You should probably define some more!

    /** Constructors */
    public MyHashMap() {
        size = 0;
        this.initialSize = 16;
        this.factor = 0.75;
        backArray = createTable(this.initialSize);
    }

    public MyHashMap(int initialSize) {
        size = 0;
        this.initialSize = initialSize;
        this.factor = 0.75;
        backArray = createTable(this.initialSize);
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        size = 0;
        this.initialSize = initialSize;
        this.factor = maxLoad;
        backArray = createTable(this.initialSize);
    }

    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        return new Node(key, value);
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        return new LinkedList<>();
    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     *
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */
    private Collection<Node>[] createTable(int tableSize) {
        return new Collection[tableSize];
    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!
    public void clear() {
        backArray = createTable(initialSize);
        size = 0;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public V get(K key) {
        int hashcode = hashcode(key,initialSize);
        if (backArray[hashcode] == null) {
            return null;
        } else {
            for ( Node x: backArray[hashcode]) {
                if (x.key.equals(key)){
                    return x.value;
                }
            }
        }
        return null;
    }

    private Node getNode(K key) {
        int hashcode = hashcode(key, initialSize);
        for (Node x: backArray[hashcode]) {
            if (x.key.equals(key)) {
                return x;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        if (containsKey(key) && get(key)!= value) {
            getNode(key).value = value;
        } else if (!containsKey(key)) {
            int hashcode = hashcode(key, initialSize);
            if (backArray[hashcode] == null) {
                backArray[hashcode] = createBucket();
            }
            backArray[hashcode].add(createNode(key,value));
            size += 1;
            resize();
        }
    }

    private void resize(){
        double N = size;
        double M = initialSize;
        if (N/M > factor) {
            Collection<Node>[] newTable = createTable(initialSize * 2);
            for (K key: keySet()) {
                int hashcode = hashcode(key, initialSize*2);
                if (newTable[hashcode] == null) {
                    newTable[hashcode] = createBucket();
                }
                newTable[hashcode].add(createNode(key, get(key)));
            }
            backArray = newTable;
            initialSize = initialSize * 2;
        }
    }

    public Set<K> keySet() {
        HashSet<K> hashSet = new HashSet<>();
        for (int i=0; i<initialSize; i++){
            if (backArray[i] != null) {
               for (Node x: backArray[i]) {
                   hashSet.add(x.key);
               }
            }
        }
        return hashSet;
    }

    public V remove(K key) {
        if (containsKey(key)){
            int hashcode = hashcode(key, initialSize);
            Node node = getNode(key);
            V returnValue = node.value;
            backArray[hashcode].remove(node);
            return returnValue;
        }
        return null;
    }

    public V remove(K key, V value) {
        if (containsKey(key)) {
            int hashcode = hashcode(key,initialSize);
            Node node = getNode(key);
            if (node.value.equals(value)) {
                backArray[hashcode].remove(node);
                return value;
            }
        }
        return null;
    }

    public Iterator<K> iterator() {
        return new mapIterator();
    }

    private class mapIterator implements Iterator<K> {
        private K[] array = (K[]) keySet().toArray();
        int wizPos = 0;
        @Override
        public boolean hasNext() {
            if (array.length >= wizPos){
                return true;
            }
            return false;
        }

        @Override
        public K next() {
            K returnValue = array[wizPos];
            wizPos++;
            return returnValue;
        }
    }

    private int hashcode(K key, int currentSize){
        int hashcode = key.hashCode();
        if (hashcode < 0) {
            hashcode = Math.floorMod(hashcode, currentSize);
        } else {
            hashcode = hashcode % currentSize;
        }
        return hashcode;
    }

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }
}
