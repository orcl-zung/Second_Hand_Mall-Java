package com.lz.secondhandmall.bean;

import com.definesys.mpaas.query.annotation.Table;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @Author: lz
 * @Since: 2019/12/17 23:45
 * @History 2019/12/17 created by lz
 */
@Table("shopping_cart")
@ApiModel(value = "购物车信息", description = "存储用户加入购物车的商品信息")
public class ShoppingCart {

    private Integer goodsId;
    private Integer userId;
    private Date creationDate;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "goodsId=" + goodsId +
                ", userId=" + userId +
                ", creationDate=" + creationDate +
                '}';
    }
}
