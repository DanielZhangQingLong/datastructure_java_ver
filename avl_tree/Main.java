package com.daniel.datastructures.avl_tree;

import com.daniel.datastructures.map.BSTMap;
import com.daniel.datastructures.utils.FileOperation;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("/Users/daniel/Work/projects/datastructure/src/com/daniel/datastructures/utils/pride-and-prejudice.txt", words)) {
            Collections.sort(words);
            // Test BST
            long startTime = System.nanoTime();
            BSTMap<String, Integer> bst = new BSTMap<>();
            for (String word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.getSize() + 1);
                else
                    bst.add(word, 1);
            }
            for (String word : words)
                bst.contains(word);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " s");

            startTime = System.nanoTime();
            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words){
                if (avl.contains(word))
                    avl.set(word, avl.getSize() + 1);
                else
                    avl.add(word, 1);
            }
            for (String word : words)
                avl.contains(word);

            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");
        }
    }
}
