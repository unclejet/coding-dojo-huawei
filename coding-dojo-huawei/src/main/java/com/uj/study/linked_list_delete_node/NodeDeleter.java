package com.uj.study.linked_list_delete_node;

import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/6/30 下午12:42
 * @description：
 */
class NodeDeleter {
    private int total;
    private int first;
    private int delete;

    private Node firstNode;

    public NodeDeleter() {
        total = 0;
    }

    public int getTotal() {
        return total;
    }

    public int getFirst() {
        return first;
    }

    public int getDelete() {
        return delete;
    }

    public void generate(List<Integer> list) {
        total = list.get(0);
        delete = list.get(list.size() - 1);
        first = list.get(1);
        firstNode = new Node(first);
        generateNodeList(list);
    }

    private boolean isValidNodeList() {
        int count = 1;
        Node next = firstNode.getNext();
        while (next != null) {
            count++;
            next = next.getNext();
        }
        return count == total - 1;
    }

    private void generateNodeList(List<Integer> list) {
        for (int i = 2; i < list.size() - 1; i = i + 2) {
            Node n = new Node(list.get(i));
            Node hn = findNode(list.get(i + 1));
            if (hn.hasNext()) {
                Node next = hn.getNext();
                n.setNext(next);
                next.setPrevious(n);
            }
            hn.setNext(n);
            n.setPrevious(hn);
        }
    }

    private Node findNode(int data) {
        if (firstNode.getData() == data)
            return firstNode;
        Node nodeNext = firstNode.getNext();
        while (nodeNext != null) {
            if (nodeNext.getData() == data)
                return nodeNext;
            nodeNext = nodeNext.getNext();
        }
        return new NullNode();
    }





    public Node getFirstNode() {
        return firstNode;
    }

    public void deleteNode() {
        Node dn = findNode(delete);
        if (dn.getPrevious() == null) {
            firstNode = dn.getNext();
        } else {
            dn.getPrevious().setNext(dn.getNext());
        }
    }

    public void print() {
        if (isValidNodeList()) {
            System.out.print(firstNode.getData() + " ");
            Node node = firstNode;
            while (node.hasNext()) {
                node = node.getNext();
                System.out.print(node.getData() + " ");
            }
        } else {
            System.out.println("invalid input, try again");
        }
    }
}
