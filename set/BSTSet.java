package com.daniel.datastructures.set;


import com.daniel.datastructures.bst.BST;
import com.daniel.datastructures.utils.FileOperation;

import java.util.ArrayList;

public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("/Users/daniel/Work/projects/datastructure/src/com/daniel/datastructures/utils/pride-and-prejudice.txt", words1);
        System.out.println("Total words: " + words1.size());

        BSTSet<String> set1 = new BSTSet<>();
        for (String word: words1)
            set1.add(word);
        System.out.println("Total unique words: " + set1.getSize());

        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("/Users/daniel/Work/projects/datastructure/src/com/daniel/datastructures/utils/a-tale-of-two-cities.txt", words2);
        System.out.println("Total words: " + words2.size());
        BSTSet set2 = new BSTSet();
        for (String word: words2)
            set2.add(word);
        System.out.println("Total unique words: " + set2.getSize());



        System.out.println("Pride and Prejudice");

//        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("/Users/daniel/Work/projects/datastructure/src/com/daniel/datastructures/utils/pride-and-prejudice.txt", words1);
        System.out.println("Total words: " + words1.size());

        LinkedListSet<String> set3 = new LinkedListSet<>();
        for (String word: words1)
            set3.add(word);
        System.out.println("Total unique words: " + set3.getSize());

//        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("/Users/daniel/Work/projects/datastructure/src/com/daniel/datastructures/utils/a-tale-of-two-cities.txt", words2);
        System.out.println("Total words: " + words2.size());
        LinkedListSet set4 = new LinkedListSet();
        for (String word: words2)
            set4.add(word);
        System.out.println("Total unique words: " + set4.getSize());
    }
}
