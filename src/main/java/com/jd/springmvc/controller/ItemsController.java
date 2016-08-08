package com.jd.springmvc.controller;

import com.jd.springmvc.po.Items;
import com.jd.springmvc.po.ItemsCustom;
import com.jd.springmvc.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/queryItemsList")
    public ModelAndView queryItems() throws Exception{
        List<Items> itemsList=itemsService.findItemsList(null);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("itemsList");
        return modelAndView;
    }
    @RequestMapping("/queryItems")
    public ModelAndView queryItemsList() throws Exception{
        List<ItemsCustom> itemsList=itemsService.findItemsCustomList(null);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("itemsList");
        return modelAndView;
    }
}
