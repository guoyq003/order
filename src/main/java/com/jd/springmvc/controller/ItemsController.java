package com.jd.springmvc.controller;

import com.jd.springmvc.controller.validation.ValidGroup1;
import com.jd.springmvc.controller.validation.ValidGroup2;
import com.jd.springmvc.po.Items;
import com.jd.springmvc.po.ItemsCustom;
import com.jd.springmvc.po.ItemsQueryVo;
import com.jd.springmvc.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("item")//窄化请求
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    //itemType最终将方法返回值放到request的key中,此处的举例为静态之，实际项目可能是从输数据库中取值
    @ModelAttribute("itemTypes")
    public Map<String,String> getItemTypesne() {
        Map<String,String> itemTypes=new HashMap<String, String>();
        itemTypes.put("101","母婴");
        itemTypes.put("102","童装");
        return itemTypes;
    }
    //使用两个不同的实现方式
    @RequestMapping("/queryItemsList")
    public ModelAndView queryItemsList() throws Exception {
        List<Items> itemsList = itemsService.findItemsList(null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("item/itemsList");
        return modelAndView;
    }

    @RequestMapping("/queryItems")
    public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
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
    //查询商品信息，输出json
    ///itemsView/{id}里边的{id}表示占位符，通过@PathVariable获取占位符中的参数，
    //如果占位符中的名称和形参名一致，在@PathVariable可以不指定名称
    @RequestMapping("/itemsView/{id}")
    public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id)throws Exception{
        //调用service查询商品信息
        ItemsCustom itemsCustom = itemsService.findItemsById(id);
        return itemsCustom;
    }
    //    @RequestMapping("editItemsSubmit")
//        public ModelAndView editItemsSubmit() throws Exception{
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("item/success");
//        return modelAndView;
//    }
    @RequestMapping("/editItemsSubmit")
    //pojo参数绑定
    //批量修改商品提交,通过ItemsQueryVo接收批量提交商品信息，将商品信息存储到ItemsQueryVo的ItemsCustoms中
    // 在需要校验的pojo前边添加@Validated，在需要校验的pojo后边添加BindingResult
    // bindingResult接收校验出错信息
    // 注意：@Validated和BindingResult bindingResult是配对出现，并且形参顺序是固定的（一前一后）。
    // value={ValidGroup1.class}指定使用ValidGroup1分组的校验
    //value = {ValidGroup1.class指定使用ValidGroup1分组校验
    //@ModelAttribute 使用这个属性来控制pojo的回显
    public String editItemsSubmit(Model model, HttpServletRequest request, Integer id,
                                  @ModelAttribute("itemsCustom") @Validated(value = {ValidGroup1.class}) ItemsCustom itemsCustom, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()){
            List<ObjectError> errors=bindingResult.getAllErrors();
            for (ObjectError objectError:errors){
                System.out.println(objectError.getDefaultMessage());
            }
            //将错误信息传到页面
            model.addAttribute("errors",errors);
            //可以使用model提交回显页面
            model.addAttribute("itemsCustom",itemsCustom);
            //出错重新到商品修改页面
            return "item/editItems";
        }
        itemsService.updateItems(id,itemsCustom);
        //重定向关键字：redirect,request数据不共享
//        return "redirect:queryItems.action";
        //跳转关键字forward，request数据共享
//        return "forward:queryItems.action";
        return "item/success";
    }
    //批量删除商品
    @RequestMapping("/batchDeleteItems")
    public String batchDeleteItems(Integer[] itemsId ) throws Exception{
        //调用service批量删除商品
        itemsService.batchDeleteItems(itemsId);
        return "item/success";
    }
    //批量修改商品页面，必须先将商品查询出来，在页面中编辑
    @RequestMapping("/batchEditItems")
    public ModelAndView batchEditItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsCustom> itemsList = itemsService.findItemsCustomList(itemsQueryVo);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("item/batchEditItems");
        return modelAndView;
    }

    @RequestMapping("/batchEditItemsSubmit")
    public String batchEditItemsSubmit(ItemsQueryVo itemsQueryVo) throws Exception{
        itemsService.batchUpdateItems(itemsQueryVo.getItemsList());
        return "item/success";
    }
}
