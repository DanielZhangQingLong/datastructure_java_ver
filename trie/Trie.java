package com.daniel.datastructures.trie;

import java.util.TreeMap;

public class Trie {

    // Define Node private class

    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    // Get Words count in Trie
    public int getSize() {
        return size;
    }

    // Add a new word to Trie
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }

        if(!cur.isWord) {
            cur.isWord = true;
            size ++;
        }
    }

    // Find a word in trie.
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    // find if there is prefix in Trie
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i ++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }


}
