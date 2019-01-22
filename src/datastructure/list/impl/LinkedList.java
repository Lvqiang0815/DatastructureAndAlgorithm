package datastructure.list.impl;

/**
 * 带头结点的单链表
 * @param <E>
 */
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

    /**
     * remove position index node
     * @param index
     */
    public void remove(int index) {
        if (index < 1 || index > this.size) {
            throw new IllegalArgumentException("The index is illegal");
        }

        Node<E> cur = this.head.next;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;

        this.size--;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        //list.reverse();
        list.remove(1);

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
