package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private int size = 0;

    private BST bst;

    private class BST {
        K key;
        V val;
        BST left;
        BST right;

        public BST(K key, V val, BST left, BST right) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public BST find(BST T, K sKey){
            if (T == null) {
                return null;
            }
            if (sKey.equals(T.key)) {
                return T;
            } else if (sKey.compareTo(T.key) < 0) {
                return find(T.left, sKey);
            } else {
                return find(T.right, sKey);
            }
        }

        public BST put(BST T, K inKey, V val){
            if (T == null){
                size += 1;
                return new BST(inKey, val, null, null);
            }
            if (inKey.compareTo(T.key) < 0){
                T.left = put(T.left, inKey, val);
            } else if (inKey.compareTo(T.key) > 0) {
                T.right = put(T.right, inKey, val);
            } else if (T.key.equals(inKey)) {
                T.val = val;
            }
            return T;
        }

    }

    @Override
    public void clear() {
        size = 0;
        bst = null;
    }

    @Override
    public boolean containsKey(K key) {
        if (bst != null) {
            BST returnBST = bst.find(bst, key);
            if (returnBST != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        if (bst != null) {
            BST returnBST = bst.find(bst, key);
            if (returnBST != null) {
                return returnBST.val;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        if (bst == null){
            bst = new BST(key, value, null, null);
            size += 1;
        } else {
            bst = bst.put(bst, key, value);
        }

    }

    public void printInOrder(){
        inorderRec(bst);
    }

    private void inorderRec(BST bst){
        if (bst != null) {
            inorderRec(bst.left);
            System.out.println(bst.key);
            inorderRec(bst.right);
        }
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTMapIterator();
    }

    private class BSTMapIterator implements Iterator<K> {
        private BST cur;
        public BSTMapIterator(){
            cur = bst;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public K next() {
            return null;
        }
    }
}
