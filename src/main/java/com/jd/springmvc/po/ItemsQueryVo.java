package com.jd.springmvc.po;

import java.util.List;

public class ItemsQueryVo {
    private Items items;
    private ItemsCustom itemsCustom;
    private List<ItemsCustom> itemsCustoms;

    public List<ItemsCustom> getItemsCustoms() {
        return itemsCustoms;
    }

    public void setItemsCustoms(List<ItemsCustom> itemsCustoms) {
        this.itemsCustoms = itemsCustoms;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }

}
