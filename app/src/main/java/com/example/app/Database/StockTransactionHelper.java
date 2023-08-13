package com.example.app.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class StockTransactionHelper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="stock_transactions.db";
    private  static final int DATABASE_VERSION= 1;


    //TABLE Creation SQL Statement
    private static final String CREATE_TABLE_STOCK_TRANSACTIONS= "CREATE TABLE " +
            StockTransaction.TABLE_NAME + "(" +
            StockTransaction.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            StockTransaction.COLUMN_TYPE + " TEXT," +
            StockTransaction.COLUMN_SECURITY_NAME + " TEXT," +
            StockTransaction.COLUMN_QUANTITY + " INTEGER," +
            StockTransaction.COLUMN_PRICE + " REAL)";

    public StockTransactionHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_STOCK_TRANSACTIONS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + StockTransaction.TABLE_NAME);
        onCreate(db);

    }

    //insert Data
    public long addStockTransaction(StockTransaction transaction){
    SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(StockTransaction.COLUMN_TYPE, transaction.getType());
        values.put(StockTransaction.COLUMN_SECURITY_NAME,transaction.getSecurityName());
        values.put(StockTransaction.COLUMN_QUANTITY,transaction.getQuantity());
        values.put(StockTransaction.COLUMN_PRICE,transaction.getPrice());

        // inserting Row
        long id=db.insert(StockTransaction.TABLE_NAME,null,values);
        db.close();
        return id;

    }
     @SuppressLint("Range")
     public List<StockTransaction> getAllStockTransactions(){
         List<StockTransaction> transactionList = new ArrayList<>();
         String selectQuery = "SELECT * FROM "+  StockTransaction.TABLE_NAME;
         SQLiteDatabase db=this.getWritableDatabase();
         Cursor cursor=db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                StockTransaction transaction=new StockTransaction();
                transaction.setId(cursor.getInt(cursor.getColumnIndex(StockTransaction.COLUMN_ID)));
                transaction.setType(cursor.getString(cursor.getColumnIndex(StockTransaction.COLUMN_TYPE)));
                transaction.setSecurityName(cursor.getString(cursor.getColumnIndex(StockTransaction.COLUMN_SECURITY_NAME)));
                transaction.setQuantity(cursor.getInt(cursor.getColumnIndex(StockTransaction.COLUMN_QUANTITY)));
                transaction.setPrice(cursor.getDouble(cursor.getColumnIndex(StockTransaction.COLUMN_PRICE)));
                transactionList.add(transaction);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return transactionList;
     }

     //UPDATE A STOCK TRANSACTION IN THE DATABASE
    public int updateStockTransaction(StockTransaction transaction){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(StockTransaction.COLUMN_TYPE, transaction.getType());
        values.put(StockTransaction.COLUMN_SECURITY_NAME, transaction.getSecurityName());
        values.put(StockTransaction.COLUMN_QUANTITY, transaction.getQuantity());
        values.put(StockTransaction.COLUMN_PRICE, transaction.getPrice());

        return db.update(StockTransaction.TABLE_NAME, values, StockTransaction.COLUMN_ID + " =? ",
                new String[]{String.valueOf(transaction.getId())});
    }

//Delete a Stock transaction from the database
    public void deleteStockTransaction(int transactionId){
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete(StockTransaction.TABLE_NAME, StockTransaction.COLUMN_ID + " =? ",
                new String[]{String.valueOf(transactionId)});
        db.close();
    }

}
