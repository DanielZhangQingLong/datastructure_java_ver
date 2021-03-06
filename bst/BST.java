package com.daniel.datastructures.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /***
     *
     * @param e The element to insert into BST.
     */
    public void add(E e) {
        root = add(root, e);
    }

    /***
     *
     * @param node a certain subtree of BST.
     * @param e the element to insert into BST.
     * @return the root node of a certain BST.
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size ++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }

    /**
     *
     * @param e the element to search.
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * Recursively called.
     * @param node a certain subtree of BST.
     * @param e the element to search.
     * @return whether e is in the subtree.
     */
    private boolean contains(Node node, E e) {
        if(node == null)
            return false;
        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    /*
        Old version.
    public void add(E e) {
        if(root == null)
            root = new Node(e);
        else
            add(root, e);
    }

    private void add(Node node, E e) {
        if (e.equals(node.e))
            return;
        else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size ++;
            return;
        } else if(e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size ++;
            return;
        }

        if (e.compareTo(node.e) < 0)
            add(node.left, e);
        else
            add(node.right, e);

    }
     */

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    // Non-Recursive Pre-order traverse
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    // Non-Recursive In-order traverse
    public void inOrderNR() {
        if (root == null)
            return;
        Node cur = root;
        Stack<Node> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            System.out.println(cur.e);
            cur = cur.right;
        }
    }

    // Non-Recursive Post-order traversal
    public void postOrderNRTwoStacks() {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            if (root.left != null)
                stack1.push(root.left);
            if (root.right != null)
                stack1.push(root.right);
            stack2.push(root);
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().e);
        }

    }

    public void postOrderItrOneStack(){

    }

    public void layerOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is Empty");
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        Node cur = node.left;
        if (cur == null)
            return node;
        else
            return minimum(cur);
    }

    public E minimumNR() {
        if (size == 0)
            throw new IllegalArgumentException("BST is Empty");
        Stack<Node> stack = new Stack<>();
        Node cur = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if(cur.left != null)
                stack.push(cur.left);
        }
        return root.e;
    }

    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        Node cur =  node.right;
        if (cur == null)
            return node;
        else
            return maximum(cur);
    }

    public E maximumNR() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        Stack<Node> stack = new Stack<>();
        Node cur = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if(cur.right != null)
                stack.push(cur.right);
        }
        return cur.e;
    }

    public E removeMin() {
        E ret = minimum();
        removeMin(root);
        return ret;
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

    public E removeMax() {
        E ret = maximum();
        removeMin(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e){

        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }
        else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        else { // e == node.e
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            else {
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = node.right = null;
                return successor;
            }

        }

    }




    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i ++)
            res.append("--");
        return res.toString();
    }
}
