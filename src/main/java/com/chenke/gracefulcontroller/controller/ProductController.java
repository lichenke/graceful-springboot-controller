package com.chenke.gracefulcontroller.controller;

import static com.chenke.gracefulcontroller.pojo.AppCode.APP_ERROR;

import com.chenke.gracefulcontroller.annotation.ExcludeControllerResponseAdvice;
import com.chenke.gracefulcontroller.exception.AppException;
import com.chenke.gracefulcontroller.pojo.Product;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiChenke
 **/
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/getById/{id}")
    public Product getById(@PathVariable Integer id) {
        return new Product(id, "Product" + id);
    }


    @PostMapping("/find")
    public Product find(@RequestBody @Validated Product product) {
        if (product.getId() == 0) {
            throw new AppException("参数有点问题哦", APP_ERROR);
        }
        return product;
    }

    @GetMapping("/health")
    @ExcludeControllerResponseAdvice
    public String healthCheck() {
        return "success";
    }
}
