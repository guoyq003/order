package com.jd.springmvc.controller;

import com.jd.springmvc.po.Items;
import com.jd.springmvc.po.ItemsCustom;
import com.jd.springmvc.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("item")//窄化请求
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/queryItemsList")
    public ModelAndView queryItems() throws Exception{
        List<Items> itemsList=itemsService.findItemsList(null);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("item/itemsList");
        return modelAndView;
    }
    @RequestMapping("/queryItems")
    public ModelAndView queryItemsList() throws Exception{
        List<ItemsCustom> itemsList=itemsService.findItemsCustomList(null);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("item/itemsList");
        return modelAndView;
    }
    //1.使用ModelAndView方式
//    @RequestMapping("editItems")
//    @RequestMapping(value = "editItems",method = {RequestMethod.POST,RequestMethod.GET})
//    public ModelAndView editItems() throws Exception{
//        ItemsCustom itemsCustom=itemsService.findItemsById(1);
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.addObject("itemsCustom",itemsCustom);
//        modelAndView.setViewName("item/editItems");
//        return modelAndView;
//    }
    //2.使用String方式
    @RequestMapping(value = "editItems",method = {RequestMethod.POST,RequestMethod.GET})
    public String editItems(Model model) throws Exception{
        ItemsCustom itemsCustom=itemsService.findItemsById(1);
        model.addAttribute("itemsCustom",itemsCustom);
        return "item/editItems";
    }
    @RequestMapping("editItemsSubmit")
    public ModelAndView editItemsSubmit() throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("item/success");
        return modelAndView;
    }
}
