package com.jd.springmvc.service;

import com.jd.springmvc.po.Items;
import com.jd.springmvc.po.ItemsCustom;
import com.jd.springmvc.po.ItemsQueryVo;

import java.util.List;

public interface ItemsService {
    //商品查询
    public List<Items> findItemsList(Items items) throws Exception;
    public List<ItemsCustom> findItemsCustomList(ItemsQueryVo itemsQueryVo)throws Exception;
}
