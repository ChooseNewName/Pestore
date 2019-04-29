package com.nf147.ssm_pet_spring.entity;

import java.math.BigDecimal;

public class Pet {
    private Integer pId;

    private Integer categoryId;

    private Integer tId;

    private String pName;

    private BigDecimal pPrice;

    private String pStatus;

    private Category category;

    private Tag tag;

    public Pet() {
    }

    public Pet(Integer categoryId, Integer tId, String pName, BigDecimal pPrice, String pStatus) {
        this.categoryId = categoryId;
        this.tId = tId;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pStatus = pStatus;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public BigDecimal getpPrice() {
        return pPrice;
    }

    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    public String getpStatus() {
        return pStatus;
    }

    public void setpStatus(String pStatus) {
        this.pStatus = pStatus;

    }

    @Override
    public String toString() {
        return "Pet{" +
                "pId=" + pId +
                ", categoryId=" + categoryId +
                ", category=" + category +
                ", tag=" + tag +
                ", tId=" + tId +
                ", pName='" + pName + '\'' +
                ", pPrice=" + pPrice +
                ", pStatus='" + pStatus + '\'' +
                '}';
    }
}