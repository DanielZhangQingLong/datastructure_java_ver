package com.daniel.datastructures.set;

import com.daniel.datastructures.utils.FileOperation;

import java.util.ArrayList;

public class Main {
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
    }
}
