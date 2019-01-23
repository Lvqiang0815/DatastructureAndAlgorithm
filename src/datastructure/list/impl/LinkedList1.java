package datastructure.list.impl;

public class LinkedList1<E> {

    private Node<E> first;
    private int size;

    public void addFirst(E e) {

        Node<E> node = new Node<>(e);

        Node<E> temp = this.first;

        node.next = temp;
        this.first = node;

        this.size++;
    }

    public void reverse() {
        //1-->2-->3
        //q 记录新链表, r 记录当前位置的前一个元素
        Node<E> p, q = null, r = null;
        Node<E> cur = this.first;

        while(cur != null) {
            p = cur;
            cur = cur.next;
            q = p;
            q.next = r;
            r = p;
        }
        this.first = q;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        Test<Integer> list = new Test<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

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
