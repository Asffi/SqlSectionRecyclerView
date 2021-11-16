package com.example.sqllite.model;

public class Items {
    String name,skuCode,image;
    int uid,boxSize,ctnSize,productId;

    public Items() {
    }

    public Items(String name, String skuCode, String image, int uid, int boxSize, int ctnSize, int productId) {
        this.name = name;
        this.skuCode = skuCode;
        this.image = image;
        this.uid = uid;
        this.boxSize = boxSize;
        this.ctnSize = ctnSize;
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getBoxSize() {
        return boxSize;
    }

    public void setBoxSize(int boxSize) {
        this.boxSize = boxSize;
    }

    public int getCtnSize() {
        return ctnSize;
    }

    public void setCtnSize(int ctnSize) {
        this.ctnSize = ctnSize;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
