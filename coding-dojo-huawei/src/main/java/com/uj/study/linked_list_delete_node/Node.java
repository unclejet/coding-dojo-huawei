package com.uj.study.linked_list_delete_node;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/6/30 下午12:42
 * @description：
 */
class Node {

    private int data;
    private Node previous;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }
}
