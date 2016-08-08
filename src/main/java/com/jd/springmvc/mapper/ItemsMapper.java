package com.jd.springmvc.mapper;

import com.jd.springmvc.po.Items;
import com.jd.springmvc.po.ItemsCustom;

import java.util.List;

public interface ItemsMapper {
    public List<Items> findItemsList(Items items) throws Exception;
    public ItemsCustom findItemsById(Integer id) throws Exception;
    public int updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
}
