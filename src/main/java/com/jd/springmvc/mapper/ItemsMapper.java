package com.jd.springmvc.mapper;

import com.jd.springmvc.po.Items;

import java.util.List;

public interface ItemsMapper {
    public List<Items> findItemsList(Items items) throws Exception;
}
