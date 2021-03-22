package com.uj.study.shopping_list;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/3/1 上午11:52
 * @description：
 */
@Getter
public class Goods {
    private int price;
    private int weight;
    private int type;
    private List<Goods> attachmentList;

    public Goods(int price, int weight, int type) {
        this.price = price;
        this.weight = weight;
        this.type = type;
        attachmentList = new ArrayList<>();
    }

    public void addAttachment(Goods goods) {
        attachmentList.add(goods);
    }

    public List<Goods> getAttachmentList() {
        return attachmentList;
    }

    public boolean isSatisfy(int total) {
        return price < total && totalPrice() < total;
    }

    public int totalPrice() {
        return attachmentList.stream().collect(Collectors.summingInt(Goods::getPrice)) + price;
    }

    public int getValue() {
        return attachmentList.stream().collect(Collectors.summingInt(g->g.getPrice() * g.getWeight()))  + price * weight ;
    }
}
