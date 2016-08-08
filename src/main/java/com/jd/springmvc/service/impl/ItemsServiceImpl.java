package com.jd.springmvc.service.impl;

import com.jd.springmvc.mapper.ItemsCustomMapper;
import com.jd.springmvc.mapper.ItemsMapper;
import com.jd.springmvc.po.Items;
import com.jd.springmvc.po.ItemsCustom;
import com.jd.springmvc.po.ItemsQueryVo;
import com.jd.springmvc.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private ItemsCustomMapper itemsCustomMapper;

    public List<Items> findItemsList(Items items) throws Exception {
        return itemsMapper.findItemsList(items);
    }

    public List<ItemsCustom> findItemsCustomList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsCustomMapper.findItemsCustomList(itemsQueryVo);
    }
}
