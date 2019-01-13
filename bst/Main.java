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
        ystem.out.println("LayerOrder");
        bst.layerOrder();

        System.out.println("Minimum");
        System.out.println(bst.minimum());
        System.out.println("Minimum Iteratively");
        System.out.println(bst.minimumNR());
        System.out.println("Maximum");
        System.out.println(bst.maximum());
        */
        System.out.println("Maximum Iteratively");
        System.out.println(bst.maximumNR());


    }
}
