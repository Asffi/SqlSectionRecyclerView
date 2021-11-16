package com.example.sqllite.utils;

public class Contracts {
    public static class Product{
        public static final String TABLE_NAME="products";
        public static final String UID="product_id";
        public static final String COMPANY_ID="company_id";
        public static final String CATEGORY_ID="category_id";
        public static final String PRODUCT_NAME="name";
        public static final String STATUS="status";
    }
    public static  class Items {
        public static final String TABLE_NAME="items";
        public static final String UID="item_id";
        public static final String PRODUCT_ID="product_id";
        public static final String ITEM_NAME="name";
        public static final String SKU_CODE="sku_code";
        public static final String BOX_SIZE="box_size";
        public static final String CTN_SIZE="ctn_size";
        public static final String IMAGE_URL="image";
    }
}
