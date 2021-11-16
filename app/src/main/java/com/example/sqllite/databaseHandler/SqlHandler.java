package com.example.sqllite.databaseHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.sqllite.utils.Contracts;
import com.example.sqllite.model.Items;
import com.example.sqllite.model.Products;

import java.util.ArrayList;
import java.util.List;


public class SqlHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="target.db" ;
    private static final int VERSION=12;

    public SqlHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null,VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + Contracts.Product.TABLE_NAME + " (" +
                Contracts.Product.UID + " INTEGER PRIMARY KEY," +
                Contracts.Product.PRODUCT_NAME + " TEXT," +
                Contracts.Product.STATUS + " TEXT,"+
                Contracts.Product.CATEGORY_ID+" INTEGER,"+
                Contracts.Product.COMPANY_ID+" INTEGER" + ")"
        );
        sqLiteDatabase.execSQL("CREATE TABLE " + Contracts.Items.TABLE_NAME + " (" +
                Contracts.Items.UID + " INTEGER PRIMARY KEY," +
                Contracts.Items.ITEM_NAME + " TEXT," +
                Contracts.Items.IMAGE_URL + " TEXT,"+
                Contracts.Items.BOX_SIZE + " INTEGER,"+
                Contracts.Items.CTN_SIZE + " INTEGER," +
                Contracts.Items.SKU_CODE + " TEXT," +
                Contracts.Items.PRODUCT_ID+" INTEGER"+")"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contracts.Product.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contracts.Items.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public void insertData(Products products , SQLiteDatabase dbHelper){

        ContentValues values = new ContentValues();
        values.put(Contracts.Product.PRODUCT_NAME, products.getName());
        values.put(Contracts.Product.UID,products.getUid() );
        values.put(Contracts.Product.CATEGORY_ID,products.getCategoryId());
        values.put(Contracts.Product.COMPANY_ID,products.getCompanyId());
        values.put(Contracts.Product.STATUS,products.getStatus());
        dbHelper.insert(Contracts.Product.TABLE_NAME, null, values);
    }

    public void addingDataInProduct(){
        SQLiteDatabase db = this.getWritableDatabase();
        //product items
        Products productOne=new Products("biscuits","published",1,1,1);
        insertData(productOne, db );
        Products productsTwo=new Products("cake","published",2,1,1);
        insertData(productsTwo, db );
        Products productThree=new Products("instant noodles","published",3,1,2);
        insertData(productThree, db );
        Products productFourth=new Products("lotte spout","published",4,1,3);
        insertData(productFourth, db );
        Products productFifth=new Products("lotte biscuit","published",5,1,4);
        insertData(productFifth, db );
        Products productSixth=new Products("pie","published",6,1,4);
        insertData(productSixth, db );
        Products productSeven=new Products("pasta","published",7,1,5);
        insertData(productSeven, db );
        Products productEigth=new Products("permium pasta","published",8,1,5);
        insertData(productEigth, db );
        Products productNinth=new Products("vermicelli","published",9,1,5);
        insertData(productNinth, db );
        Products productTenth=new Products("snacks","published",10,1,6);
        insertData(productTenth, db );

    }

    public void insertDataInItems(Items items,SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(Contracts.Items.ITEM_NAME, items.getName());
        values.put(Contracts.Items.UID,items.getUid() );
        values.put(Contracts.Items.BOX_SIZE,items.getBoxSize());
        values.put(Contracts.Items.CTN_SIZE,items.getCtnSize());
        values.put(Contracts.Items.PRODUCT_ID,items.getProductId());
        values.put(Contracts.Items.IMAGE_URL,items.getImage());
        values.put(Contracts.Items.SKU_CODE,items.getSkuCode());
        db.insert(Contracts.Items.TABLE_NAME, null, values);
    }

    public void addingDataInItems(){
        SQLiteDatabase database= this.getWritableDatabase();
        //item for one
        Items itemOne = new Items("ALP G72 - ALPHA S/P RS.10","G72","https://rahatmedia.com/kolson/uploads/sku/5.png",1,0,18,1);
        insertDataInItems(itemOne,database);
        Items itemTwo = new Items("ALP G71 - ALPHA T/P RS.5","G71","https://rahatmedia.com/kolson/uploads/sku/5.png",2,0,18,1);
        insertDataInItems(itemTwo,database);
        Items itemThird = new Items("BRV - G56 - BRAVO BP","G56","https://rahatmedia.com/kolson/uploads/sku/5.png",3,0,18,1);
        insertDataInItems(itemThird,database);
        Items itemFourth = new Items("BRV - G6 - BRAVO FP","G6","https://rahatmedia.com/kolson/uploads/sku/5.png",4,0,96,1);
        insertDataInItems(itemFourth,database);
        Items itemFifth = new Items("BRV - G36 - BRAVO SP","G36","https://rahatmedia.com/kolson/uploads/sku/5.png",5,0,12,1);
        insertDataInItems(itemFifth,database);
        //item for second
        Items itemSixth= new Items("C.CK - CC11 - O.FRESH C.CAKE-STRW","CC11","https://rahatmedia.com/kolson/uploads/sku/5.png",6,0,24,2);
        insertDataInItems(itemSixth,database);
        Items itemSeventh= new Items("C.CK - CC12 - O.FRESH C.CAKE-CHOC","CC12","https://rahatmedia.com/kolson/uploads/sku/5.png",7,0,24,2);
        insertDataInItems(itemSeventh,database);
        Items itemEigth= new Items("C.CK - CC13 - O.FRESH C.CAKE-B.BER","CC13","https://rahatmedia.com/kolson/uploads/sku/5.png",8,0,24,2);
        insertDataInItems(itemEigth,database);
        Items itemNinth= new Items("C.CK - CC14 - O.FRESH C.CAKE-BANA","CC14","https://rahatmedia.com/kolson/uploads/sku/5.png",9,0,24,2);
        insertDataInItems(itemNinth,database);
        Items itemTenth= new Items("O.F - C4 - O.FRESH STRAW JAM","C4","https://rahatmedia.com/kolson/uploads/sku/5.png",10,0,24,2);
        insertDataInItems(itemTenth,database);
        //item for third
        Items itemEleventh= new Items("N.D - NC3 -CUP NOODLE TIKKA","NC3","https://rahatmedia.com/kolson/uploads/sku/5.png",11,0,24,3);
        insertDataInItems(itemEleventh,database);
        Items itemTwelvth= new Items("N.D - N1CP PACK NOODLE CHICKEN FP","N1CP","https://rahatmedia.com/kolson/uploads/sku/5.png",12,0,18,3);
        insertDataInItems(itemTwelvth,database);
        Items itemThirteenth= new Items("N.D - N2CP PACK NOODLE CHATPATTA FP","N2CP","https://rahatmedia.com/kolson/uploads/sku/5.png",13,0,18,3);
        insertDataInItems(itemThirteenth,database);
        Items itemFourteenth= new Items("N.D - N1 - PACK NOODLE CHICKEN","N1","https://rahatmedia.com/kolson/uploads/sku/5.png",14,0,72,3);
        insertDataInItems(itemFourteenth,database);
        Items itemFifteenth= new Items("N.D - N2 - PACK NOODLE CHATPATTA","N2","https://rahatmedia.com/kolson/uploads/sku/5.png",15,0,72,3);
        insertDataInItems(itemFifteenth,database);
        //item for fourth
        Items itemSixteenth= new Items("L.S - LS04 - LOTTE SPOUT STRAWBERRY 23.8G","LS04","https://rahatmedia.com/kolson/uploads/sku/5.png",16,0,24,4);
        insertDataInItems(itemSixteenth,database);
        Items itemSeventeenth= new Items("L.S - LS06 - LOTTE SPOUT (SPR-PEP-STR) 23.8G","LS06","https://rahatmedia.com/kolson/uploads/sku/5.png",17,0,24,4);
        insertDataInItems(itemSeventeenth,database);
        Items itemEighteenth= new Items("L.S - LS11 - LOTTE SPOUT SPEARMINT","LS11","https://rahatmedia.com/kolson/uploads/sku/5.png",18,0,36,4);
        insertDataInItems(itemEighteenth,database);
        Items itemNinteenth= new Items("L.S - LS12 - LOTTE SPOUT PEPPERMINT","LS12","https://rahatmedia.com/kolson/uploads/sku/5.png",19,0,36,4);
        insertDataInItems(itemNinteenth,database);
        Items itemTwenty= new Items("L.S - LS13 - LOTTE SPOUT CINNAMON","LS13","https://rahatmedia.com/kolson/uploads/sku/5.png",20,0,36,4);
        insertDataInItems(itemTwenty,database);
    }

    public List<Products> getAllData(){
        SQLiteDatabase database= this.getReadableDatabase();
        List<Products> listProduct= new ArrayList<>();
        Cursor cursor = database.rawQuery(" Select  * from " + Contracts.Product.TABLE_NAME,null);

        if (cursor.moveToFirst()) {
            do {
                Products products=new Products();
                products.setUid(cursor.getInt(cursor.getColumnIndexOrThrow(Contracts.Product.UID)));
                products.setName(cursor.getString(cursor.getColumnIndexOrThrow(Contracts.Product.PRODUCT_NAME)));
                products.setStatus(cursor.getString(cursor.getColumnIndexOrThrow(Contracts.Product.STATUS)));
                products.setCategoryId(cursor.getInt(cursor.getColumnIndexOrThrow(Contracts.Product.CATEGORY_ID)));
                products.setCompanyId(cursor.getInt(cursor.getColumnIndexOrThrow(Contracts.Product.COMPANY_ID)));
                listProduct.add(products);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return listProduct;
    }

    public List<Items> getAllFromItems(){
        SQLiteDatabase database= this.getReadableDatabase();
        List<Items> listItems= new ArrayList<>();
        Cursor cursor = database.rawQuery(" Select  * from " + Contracts.Items.TABLE_NAME,null);

        if (cursor.moveToFirst()) {
            do {
                Items items=new Items();
                items.setUid(cursor.getInt(cursor.getColumnIndexOrThrow(Contracts.Items.UID)));
                items.setName(cursor.getString(cursor.getColumnIndexOrThrow(Contracts.Items.ITEM_NAME)));
                items.setImage(cursor.getString(cursor.getColumnIndexOrThrow(Contracts.Items.IMAGE_URL)));
                items.setBoxSize(cursor.getInt(cursor.getColumnIndexOrThrow(Contracts.Items.BOX_SIZE)));
                items.setCtnSize(cursor.getInt(cursor.getColumnIndexOrThrow(Contracts.Items.CTN_SIZE)));
                items.setProductId(cursor.getInt(cursor.getColumnIndexOrThrow(Contracts.Items.PRODUCT_ID)));
                items.setSkuCode(cursor.getString(cursor.getColumnIndexOrThrow(Contracts.Items.SKU_CODE)));
                listItems.add(items);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return listItems;
    }

    public String getProductNameById(int productId) {
        SQLiteDatabase database= this.getReadableDatabase();
        String productName="";
        Cursor cursor= database.rawQuery("select * from "+Contracts.Product.TABLE_NAME+
                " where "+ Contracts.Product.UID  + "=?",new String[]{String.valueOf(productId)});
        if (cursor.moveToFirst()){
            do {
                productName=cursor.getString(cursor.getColumnIndexOrThrow(Contracts.Product.PRODUCT_NAME));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return productName;
    }
}
