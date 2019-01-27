package com.daniel.datastructures.linked_list;

public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }

    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Add a node at head of the linked list.
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        // Gracefully
        add(0, e);
    }

    // Add new node e, in given index
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index");
        Node prev = dummyHead;
        for (int i = 0; i < index; i ++)
            prev = prev.next;
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        // Gracefully
        prev.next = new Node(e, prev.next);
        size ++;
    }

    // Add new node e at the tail of the list
    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Illegal index");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Illegal index");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i ++)
            cur = cur.next;
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
//        for (int i = 0; i < size; i ++) {
//            if (cur.e.equals(e))
//                return true;
//            cur = cur.next;
//        }
//        return false;
        while (cur != null){
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Illegal index");
        Node prev = dummyHead;
        for (int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size --;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
//        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
    }


}