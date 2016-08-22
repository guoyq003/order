package com.jd.springmvc.po;

import com.jd.springmvc.controller.validation.ValidGroup1;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
public class Items {
    private int id;
    //group:此校验属于哪个分组，group可以定义多个分组
    @Size(min = 1,max = 30,message = "{items.name.length.error}",groups = {ValidGroup1.class})
    private String name;
    @NotNull(message = "{items.createTime.isNUll}")
    private float price;
    private String detail;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
