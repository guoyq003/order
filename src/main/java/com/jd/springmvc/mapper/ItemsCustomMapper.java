package com.jd.springmvc.mapper;

import com.jd.springmvc.po.ItemsCustom;
import com.jd.springmvc.po.ItemsQueryVo;

import java.util.List;

public interface ItemsCustomMapper {
    public List<ItemsCustom> findItemsCustomList(ItemsQueryVo itemsQueryVo)throws Exception;
}
