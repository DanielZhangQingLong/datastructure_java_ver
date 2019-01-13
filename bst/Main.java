package com.daniel.datastructures.bst;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num: nums)
           bst.add(num);
        /*
        System.out.println("Preorder");
        bst.preOrder();
        System.out.println("PreOrderNR");
        bst.preOrderNR();
        System.out.println("Inorder");
//        System.out.println(bst);
        bst.inOrder();
        System.out.println("Inorder NR");
        bst.inOrderNR();
        System.out.println("PostOrder");
        bst.postOrder();

        System.out.println("PostorderIterativelyWithTwoStacks");
        bst.postOrderNRTwoStacks();
        */

        System.out.println("LayerOrder");
        bst.layerOrder();


    }
}
