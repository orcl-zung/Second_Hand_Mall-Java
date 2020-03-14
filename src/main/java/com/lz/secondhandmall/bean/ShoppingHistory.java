package com.lz.secondhandmall.bean;

import com.definesys.mpaas.query.annotation.Table;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description: 历史商品实体类
 * @Author: lz
 * @Since: 2019/12/17 23:46
 * @History 2019/12/17 created by lz
 */
@Table("shopping_history")
@ApiModel(value = "历史商品信息", description = "存储历史商品信息")
public class ShoppingHistory {

    private Integer goodsId;
    private Integer buyersId;
    private Integer sellerId;
    private Date creationDate;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getBuyersId() {
        return buyersId;
    }

    public void setBuyersId(Integer buyersId) {
        this.buyersId = buyersId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "ShoppingHistory{" +
                "goodsId=" + goodsId +
                ", buyersId=" + buyersId +
                ", sellerId=" + sellerId +
                ", creationDate=" + creationDate +
                '}';
    }
}
