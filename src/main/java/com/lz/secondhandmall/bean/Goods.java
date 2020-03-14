package com.lz.secondhandmall.bean;

import com.definesys.mpaas.query.annotation.Table;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * @copyright: Shanghai Definesys Company.All rights reserved.
 * @description: 商品实体类
 * @author: lz
 * @since: 2019/12/17 23:44
 * @history 2019/12/17 created by lz
 */
@Table("goods")
@ApiModel(value = "商品信息", description = "存储商品信息")
public class Goods {

    private Integer goodsId;
    private Integer userId;
    private String goodsName;
    private String goodsPicture;
    private String goodsKinds;
    private String goodsFlag;
    private String goodsDesc;
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public String getGoodsKinds() {
        return goodsKinds;
    }

    public void setGoodsKinds(String goodsKinds) {
        this.goodsKinds = goodsKinds;
    }

    public String getGoodsFlag() {
        return goodsFlag;
    }

    public void setGoodsFlag(String goodsFlag) {
        this.goodsFlag = goodsFlag;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
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
                ", goodsName='" + goodsName + '\'' +
                ", goodsPicture='" + goodsPicture + '\'' +
                ", goodsKinds='" + goodsKinds + '\'' +
                ", goodsFlag='" + goodsFlag + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

}
