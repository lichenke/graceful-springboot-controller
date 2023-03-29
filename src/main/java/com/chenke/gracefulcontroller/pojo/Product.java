package com.chenke.gracefulcontroller.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author LiChenke
 **/
public class Product {

    @Min(value = 0, message = "商品id不能为负数")
    private Integer id;

    @NotNull(message = "商品名称不能为空")
    private String name;


    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
