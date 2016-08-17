package com.jd.springmvc.controller;

import com.jd.springmvc.po.Items;
import com.jd.springmvc.po.ItemsCustom;
import com.jd.springmvc.po.ItemsQueryVo;
import com.jd.springmvc.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.PublicKey;
import java.util.List;

@Controller
@RequestMapping("item")//窄化请求
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    //使用两个不同的实现方式
    @RequestMapping("/queryItemsList")
    public ModelAndView queryItems() throws Exception {
        List<Items> itemsList = itemsService.findItemsList(null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("item/itemsList");
        return modelAndView;
    }

    @RequestMapping("/queryItems")
    public ModelAndView queryItemsList(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsCustom> itemsList = itemsService.findItemsCustomList(itemsQueryVo);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
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
    @RequestMapping(value = "/editItems", method = {RequestMethod.POST, RequestMethod.GET})
    //参数绑定，简单类型
    //@RequestParam 形参中和pojo中的属性名称不一致时,使用该注解
    //required 指定参数是否必传入
    //defaultValue设置默认值，参数未传入时，将默认值和形参绑定(required = true,defaultValue = "1")
    public String editItems(Model model,@RequestParam(value = "id") Integer itemsId) throws Exception {
        ItemsCustom itemsCustom = itemsService.findItemsById(itemsId);
        model.addAttribute("itemsCustom", itemsCustom);
        return "item/editItems";
    }

    //    @RequestMapping("editItemsSubmit")
//        public ModelAndView editItemsSubmit() throws Exception{
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("item/success");
//        return modelAndView;
//    }
    @RequestMapping("/editItemsSubmit")
    //pojo参数绑定
    public String editItemsSubmit(HttpServletRequest request,Integer id,ItemsCustom itemsCustom) throws Exception {
        itemsService.updateItems(id,itemsCustom);
        //重定向关键字：redirect,request数据不共享
//        return "redirect:queryItems.action";
        //跳转关键字forward，request数据共享
//        return "forward:queryItems.action";
        return "item/success";
    }
    //批量删除信息
    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[] itemsId ) throws Exception{
        //调用service批量删除商品
        return "item/success";
    }
//    //批量修改商品页面，必须先将商品查询出来，在页面中编辑
//    @RequestMapping("/batchEditItems")
//    public ModelAndView editItemsQuery(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
//        List<ItemsCustom> itemsList = itemsService.findItemsCustomList(itemsQueryVo);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("itemsList", itemsList);
//        modelAndView.setViewName("item/batchEditItems");
//        return modelAndView;
//    }
    //批量修改商品提交
//    public String batchEditItemsSubmit(ItemsQueryVo itemsQueryVo) throws Exception{
//        return "success";
//    }
}
