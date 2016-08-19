package com.jd.springmvc.mapper;

import com.jd.springmvc.po.Items;
import com.jd.springmvc.po.ItemsCustom;
import com.jd.springmvc.po.ItemsQueryVo;
import org.apache.ibatis.annotations.Param;

import javax.xml.registry.infomodel.User;
import java.util.List;

public interface ItemsMapper {
    public List<Items> findItemsList(Items items) throws Exception;
    public ItemsCustom findItemsById(Integer id) throws Exception;
    //注意mapper的接口和service的接口的区别
    public int updateItems(ItemsCustom itemsCustom) throws Exception;
    public boolean batchDeleteItems(Integer[] itemsId) throws Exception;
    public void batchUpdateItems(List<ItemsCustom> itemsList) throws Exception;
}
