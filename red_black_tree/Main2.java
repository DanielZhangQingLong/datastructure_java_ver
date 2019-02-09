package com.daniel.datastructures.red_black_tree;

import com.daniel.datastructures.avl_tree.AVLTree;
import com.daniel.datastructures.bst.BST;

import java.util.ArrayList;
import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        int n = 20000000;

        Random random = new Random();
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < n; i ++)
            testData.add(random.nextInt(Integer.MAX_VALUE));

        long starTime = System.nanoTime();
        BST<Integer> bst = new BST<>();
        for (Integer x: testData) {
            bst.add(x);
        }

        long endTime = System.nanoTime();

        double time = (endTime - starTime) / 1000000000.0;
        System.out.println("BST: " + time + " s");

        starTime = System.nanoTime();
        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x: testData) {
            avl.add(x, null);
        }

        endTime = System.nanoTime();

        time = (endTime - starTime) / 1000000000.0;
        System.out.println("AVL Tree: " + time + " s");

        starTime = System.nanoTime();
        RBTree<Integer, Integer> rbt = new RBTree<>();
        for (Integer x: testData) {
            rbt.add(x, null);
        }
        endTime = System.nanoTime();

        time = (endTime - starTime) / 1000000000.0;
        System.out.println("Red-Black Tree: " + time + " s");

    }
}
