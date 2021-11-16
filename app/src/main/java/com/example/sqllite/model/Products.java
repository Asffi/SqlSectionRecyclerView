package com.example.sqllite.model;

public class Products {
private String name,status;
private int uid, companyId,categoryId;

    public Products(String name, String status, int uid, int companyId, int categoryId) {
        this.name = name;
        this.status = status;
        this.uid = uid;
        this.companyId = companyId;
        this.categoryId = categoryId;
    }

    public Products() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
