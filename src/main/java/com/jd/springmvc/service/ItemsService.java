package com.jd.springmvc.service;

import com.jd.springmvc.po.Items;
import com.jd.springmvc.po.ItemsCustom;
import com.jd.springmvc.po.ItemsQueryVo;

import java.util.List;

public interface ItemsService {

    public List<Items> findItemsList(Items items) throws Exception;
    public List<ItemsCustom> findItemsCustomList(ItemsQueryVo itemsQueryVo)throws Exception;
    public ItemsCustom findItemsById(Integer id) throws Exception;
    public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
    public boolean batchDeleteItems(Integer[] itemsId) throws Exception;
}
