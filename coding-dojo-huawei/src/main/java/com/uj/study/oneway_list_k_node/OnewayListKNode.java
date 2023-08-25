package com.uj.study.oneway_list_k_node;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/24 下午12:51
 * @description：
 */
public class OnewayListKNode {
    public static int getKNode(int k, ListNode ln) {
        int length = getLength(ln);
        int target = length - k;
        ListNode knode = target > 0 ? ln.getM_pNext() : ln;
        while (--target > 0) {
            knode = knode.getM_pNext();
        }
        return knode.getM_nKey();
    }

    private static int getLength(ListNode ln) {
        int length = 1;
        ListNode next = ln.getM_pNext();
        while (next != null) {
            next = next.getM_pNext();
            length++;
        }
        return length;
    }

    public static ListNode buildList(int[] data) {
        ListNode result = new ListNode(data[0]);
        ListNode current = result;
        for (int i = 1; i < data.length; i++) {
            ListNode next = new ListNode(data[i]);
            current.setM_pNext(next);
            current = next;
        }
        return result;
    }
}
