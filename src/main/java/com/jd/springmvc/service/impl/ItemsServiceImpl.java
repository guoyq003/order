package com.jd.springmvc.service.impl;

import com.jd.springmvc.mapper.ItemsCustomMapper;
import com.jd.springmvc.mapper.ItemsMapper;
import com.jd.springmvc.po.Items;
import com.jd.springmvc.po.ItemsCustom;
import com.jd.springmvc.po.ItemsQueryVo;
import com.jd.springmvc.service.ItemsService;
import org.springframework.beans.BeanUtils;
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

    public ItemsCustom findItemsById(Integer id) throws Exception {
        Items items=itemsMapper.findItemsById(id);
        ItemsCustom itemsCustom=new ItemsCustom();
        BeanUtils.copyProperties(items,itemsCustom);
        return itemsCustom;
    }

    public boolean batchDeleteItems(Integer[] itemsId) throws Exception {
        return itemsMapper.batchDeleteItems(itemsId);
    }

    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
        itemsCustom.setId(id);
        itemsMapper.updateItems(itemsCustom);
    }

    public List<ItemsCustom> findItemsCustomList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsCustomMapper.findItemsCustomList(itemsQueryVo);
    }
}
