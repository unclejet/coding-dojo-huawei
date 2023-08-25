package com.uj.study.oneway_list_k_node;

/**
 * @author ：UncleJet
 * @date ：Created in 2023/8/24 下午12:50
 * @description：
 */
class ListNode {
    private int m_nKey;
    private ListNode m_pNext;

    public ListNode(int m_nKey) {
        this.m_nKey = m_nKey;
    }

    public int getM_nKey() {
        return m_nKey;
    }

    public ListNode getM_pNext() {
        return m_pNext;
    }

    public void setM_pNext(ListNode m_pNext) {
        this.m_pNext = m_pNext;
    }
}
