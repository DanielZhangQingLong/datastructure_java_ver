package com.daniel.datastructures.avl_tree;

import com.daniel.datastructures.map.Map;
import com.daniel.datastructures.utils.FileOperation;
import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1 ; i < keys.size(); i ++)
            if (keys.get(i-1).compareTo(keys.get(i)) > 0)
                return false;
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null)
            return;
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null)
            return true;
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1)
            return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }



    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    //
    //          y                               x
    //         / \                            /   \
    //        x  T4                          z     y
    //       / \       ------------->       / \    / \
    //      z   T3                         T1  T2 T3 T4
    //     / \
    //    T1 T2
    //

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        x.right = y;
        y.left = T3;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    //
    //          y                               x
    //         / \                            /   \
    //        T1  x                          y     z
    //           / \  ------------->        / \   / \
    //          T2  z                      T1 T2 T3 T4
    //             / \
    //            T3 T4
    //

    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;
        x.left = y;
        y.right = T2;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null){
            size ++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else
            node.value = value;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balanceFactor = getBalanceFactor(node);

        // Left-Left Case
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
            return rightRotate(node);

        // Right-Right Case
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
            return leftRotate(node);

        // Left-Right Case
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right-Left Case
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0 ) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private Node getNode(Node node, K key) {
        if (node == null)
            return null;
        if (key.equals(node.key)){
            return node;
        }
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }


    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        node.value = value;
    }


    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        root = remove(root, key);
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null)
            return null;
        Node retNode;
        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            retNode = node;
        }
        else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        }
        else { // e == node.e
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                retNode = rightNode;
            }
            else if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                retNode = leftNode;
            }
            else {
                Node successor = minimum(node.right);
//                successor.right = removeMin(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                retNode = successor;
            }
        }

        if (retNode == null)
            return null;

        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        int balanceFactor = getBalanceFactor(retNode);

        // Left-Left Case
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0)
            return rightRotate(retNode);

        // Right-Right Case
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0)
            return leftRotate(retNode);

        // Left-Right Case
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }

        // Right-Left Case
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0 ) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("/Users/daniel/Work/projects/datastructure/src/com/daniel/datastructures/utils/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word: words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));

            System.out.println("is BST : " + map.isBST());
            System.out.println("is Banlanced : " + map.isBalanced());

            for (String word : words) {
                map.remove(word);
                if (!map.isBalanced() || !map.isBST())
                    throw new RuntimeException("Error");
            }
        }

    }

}