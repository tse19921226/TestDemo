package com.example.tse_chen.demo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper 
{
   public static final String TABLE_DATA = "Data";     // table name
   public static final String TABLE_INDEX = "Device";  // index name	   
   private final static String DATABASE_NAME = "demo.db";  // database name
   public static final String RowID = "_RowID";
   public static final String DeviceID = "_DeviceID";
   public static final String Address = "_Address";	
   public static final String Date = "_Date";	
   public static final String ThermoData = "_ThermoData";	  	   
   private final static int DATABASE_VERSION = 1;  // database version	
   
   private SQLiteDatabase db;
	   	   
	   
   public DBHelper(Context context) 
   {	
       super(context, DATABASE_NAME, null, DATABASE_VERSION);
       db = this.getWritableDatabase();	
   }

   @Override
   public void onCreate(SQLiteDatabase db) 
   {
	     final String INIT_TABLE1 = 
	    	     "CREATE TABLE IF NOT EXISTS " + TABLE_DATA + " (" 
	          +  "_RowID INTEGER PRIMARY KEY AUTOINCREMENT, " 
	    	  + DeviceID + " CHAR, "
	          + Address + " CHAR,"
	          + Date + " CHAR, " 
	          + ThermoData + " CHAR);"; 
	     	        
	     final String INIT_TABLE2 = 
	    		 "CREATE INDEX IF NOT EXISTS "
	          + TABLE_INDEX + " ON "
	    	  + TABLE_DATA+ "(" + Address + "); ";
    
	     db.execSQL(INIT_TABLE1);
	     db.execSQL(INIT_TABLE2);
   }

   @Override
   // update Table
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
   {
	     final String DROP_TABLE1 = "DROP TABLE IF EXISTS " + TABLE_DATA;
	     final String DROP_TABLE2 = "DROP INDEX IF EXISTS " + TABLE_INDEX;
	     db.execSQL(DROP_TABLE1);
	     db.execSQL(DROP_TABLE2);
	     onCreate(db);
  }

   public Cursor getAll() 
   {	   
	   Cursor cursor = db.query(TABLE_DATA,		                    // table
		new String[] {RowID, DeviceID, Address, Date, ThermoData},	// get which column
		null, // WHERE
		null, // WHERE ���Ѽ�
		null, // GROUP BY
		null, // HAVING
		null  // ORDOR BY
		);
		// �`�N�G���g�|�X��		
		if (cursor != null) {
			cursor.moveToFirst();
		}
		return cursor;			
	}
   
	// ����S�wrow
	public Cursor get(String address) throws SQLException 
	{			
		
		Cursor cursor = db.rawQuery( 
				"SELECT " + RowID +  ", " + DeviceID + ", " + Date + ", " + ThermoData  
			 + " FROM " + TABLE_DATA 
			 + " WHERE " + Address + "= '"+ address +"';", null);
		
		// �`�N�G���g�|�X��		
		if (cursor != null) {
			cursor.moveToFirst();	//�N���в���Ĥ@�����
		}
		return cursor;		
	}
   
	//�s�W�@���O���A���\�^��rowID�A���Ѧ^��-1
	public long create(String deviceID, String address, String date, String data) {
		ContentValues args = new ContentValues();
		args.put(DeviceID, deviceID);
		args.put(Address, address);
		args.put(Date, date);
		args.put(ThermoData, data);
				
		return db.insert(TABLE_DATA, null, args);
    }   
	
	//based on address to delete rowID data
	public void delete(String address) {
		
		Cursor cursor = db.rawQuery( 
				"SELECT " + RowID   
			 + " FROM " + TABLE_DATA 
			 + " WHERE " + Address + "= '"+ address +"';", null);
		
		// �`�N�G���g�|�X��		
		if (cursor != null) {
			cursor.moveToFirst();
		}		

		int rows_num = cursor.getCount();	//���o��ƪ�C��	
		
		if(rows_num != 0) 
		{	
			do
			{
				 int id = cursor.getInt(0);		
				 db.delete(TABLE_DATA,	//��ƪ�W��
						RowID + "=" + id,			//WHERE
						null				//WHERE���Ѽ�
						);
			}
			while(cursor.moveToNext());
		}		
		

	}	
	
	// based on address to update DeviceID
	public void update(String address, String updateData, int index) //, String address, String date, String data)
	{
		ContentValues args = new ContentValues();
		
		Cursor cursor = db.rawQuery( 
				"SELECT " + RowID   
			 + " FROM " + TABLE_DATA 
			 + " WHERE " + Address + "= '"+ address +"';", null);
		
		// �`�N�G���g�|�X��		
		if (cursor != null) {
			cursor.moveToFirst();	//�N���в���Ĥ@�����
		}		

		int rows_num = cursor.getCount();	//���o��ƪ�C��	
		
		if(rows_num != 0) 
		{	
			do
			{
					int id = cursor.getInt(0);		
					switch(index)
					{
						 case 1:  // update DeviceID
							args.put(DeviceID, updateData);
							db.update(TABLE_DATA,	//��ƪ�W��
									args,				//VALUE
									RowID + "=" + id,			//WHERE
									null				//WHERE���Ѽ�
									);
			
					}
			}
			while(cursor.moveToNext());
		}
				
	}	
	
	
   
}