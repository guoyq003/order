package com.jd.springmvc.mapper;

import com.jd.springmvc.po.Items;
import com.jd.springmvc.po.ItemsCustom;
import com.jd.springmvc.po.ItemsQueryVo;

import java.util.List;

public interface ItemsMapper {
    public List<Items> findItemsList(Items items) throws Exception;
    public ItemsCustom findItemsById(Integer id) throws Exception;
    //注意mapper的接口和service的接口的区别
    public int updateItems(ItemsCustom itemsCustom) throws Exception;
    public boolean batchDeleteItems(Integer[] itemsId) throws Exception;
    public int batchUpdateItems(List<ItemsQueryVo> itemsQueryVos)throws Exception;
}
