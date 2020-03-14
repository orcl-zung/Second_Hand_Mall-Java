package com.lz.secondhandmall.bean;

import com.definesys.mpaas.query.annotation.Table;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description: 用户收藏商品实体类
 * @Author: lz
 * @Since: 2019/12/17 23:44
 * @History 2019/12/17 created by lz
 */
@Table("collection")
@ApiModel(value = "被收藏的商品信息", description = "存储用户收藏的商品信息")
public class Collection {

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
        return "Collection{" +
                "goodsId=" + goodsId +
                ", userId=" + userId +
                ", creationDate=" + creationDate +
                '}';
    }
}
