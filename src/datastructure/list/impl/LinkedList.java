package datastructure.list.impl;

public class LinkedList<E> {

    private Node<E> head;
    private int size;

    public LinkedList() {
        this.head = new Node<>(null);
    }

    /**
     * head insert
     * @param e
     */
    public void addFirst(E e) {
        Node<E> node = new Node<>(e);

        Node<E> temp = head.next;
        node.next = temp;
        head.next = node;

        this.size++;
    }

    /**
     * reverse the list
     */
    public void reverse() {
        Node<E> cur, newLink;
        cur = head.next;
        head.next = null;
        while (cur != null) {
            newLink = cur;
            cur = cur.next;
            newLink.next = head.next;
            head.next = cur;
        }
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.reverse();

        System.err.println(list.size());
    }

    private class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
