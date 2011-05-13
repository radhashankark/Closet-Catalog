package com.yaseriesapps.closetcatalog;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper 
{
	private final String LOGTAG = "ClosetCatalog";
	private static final String DATABASE_NAME = "Catalog";
	private static final int DATABASE_VERSION = 2;
	
	private static final String TABLE_CREATE = "CREATE TABLE Catalog (ITEMNUMBER NUMBER, NAME TEXT, CATEGORY TEXT, DATESAVED TEXT, LASTUPDATED TEXT, DESCRIPTION TEXT, IMAGECOUNT NUMBER, IMAGENAMES TEXT);";
	
	SQLiteDatabase database = null;
	
	DBHelper(Context context) 
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        database = getWritableDatabase();
    }

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL(TABLE_CREATE);
		Log.d(LOGTAG, "Database created, Query : " + TABLE_CREATE);
	}

	@Override
	public void onOpen(SQLiteDatabase db) 
	{
		// TODO Auto-generated method stub
		Log.d(LOGTAG, "Database opened.");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// TODO Auto-generated method stub
		Log.d(LOGTAG, "Database needs to be upgraded");
	}

	public void saveItem(int itemNumber, String name, String category, String dateSaved, String lastUpdated, String description, int imageCount, String imageNames)
	{
		Log.d(LOGTAG, "DBHelper : Saving item");
		if (database == null)
			database = getWritableDatabase();
		
		String insertStatement = "INSERT INTO Catalog VALUES ('" + itemNumber + "', '" + name + "', '" + category + "', '" + dateSaved + "', '" + lastUpdated + "', '" + description + "', '" + imageCount + "', '"  + imageNames + "')";
		
		Log.d(LOGTAG, "DBHelper : Inserting values with " + insertStatement);
		database.execSQL(insertStatement); // Autologin for current creds
		Log.d(LOGTAG, "DBHelper : Inserted item");
	}
	
	public int getItemCount()
	{
		if (database == null)
			database = getWritableDatabase();
		
		Cursor c = database.rawQuery("SELECT * FROM Catalog", null);
		int itemCount = c.getCount();
		
		c.close();
		Log.d(LOGTAG, "DBHelper : Item Count : " + itemCount);
		return itemCount;
	}
	
	public boolean isItemNameUnique(String itemName)
	{
		if (database == null)
			database = getWritableDatabase();
		
		Cursor c = database.rawQuery("SELECT * FROM Catalog WHERE NAME = '" + itemName + "'" , null);
		if (c.getCount() > 0) // 
		{
			c.close();
			return false; // We have an item saved with itemName already. The new name is not unique.
		}
		else
		{
			c.close();
			return true; // If there's no row with the same itemName, it is unique
		}
	}
	
	public String[] getItemNames()
	{
		int itemCount = getItemCount(); 
		String[] itemNames = new String[itemCount];

		if (database == null)
			database = getWritableDatabase();

		Cursor c = database.rawQuery("SELECT NAME FROM Catalog", null);
		
		for(int i=0; i < c.getCount(); i++)
		{
			itemNames[i] = c.getString(0); // There is only one column in the result
			Log.d(LOGTAG, "DBHelper : Item " + i + " name : " + itemNames[i]);
			c.moveToNext();
		}
		
		return itemNames;
	}

	public String[] getCategoryNames()
	{
		int itemCount = getItemCount(); 
		String[] categoryNames = new String[itemCount];

		if (database == null)
			database = getWritableDatabase();

		Cursor c = database.rawQuery("SELECT CATEGORY FROM Catalog", null);
		
		for(int i=0; i < c.getCount(); i++)
		{
			categoryNames[i] = c.getString(0); // There is only one column in the result
			Log.d(LOGTAG, "DBHelper : Item " + i + " name : " + categoryNames[i]);
			c.moveToNext();
		}
		
		return categoryNames;
	}
	
	public String[] getItem(String itemName)
	{
		String[] itemDetails = new String[8];

		if (database == null)
			database = getWritableDatabase();

		Cursor c = database.rawQuery("SELECT NAME FROM Catalog WHERE NAME = '" + itemName + "'", null);
		
		itemDetails[0] = c.getString(0); // ITEMNUMBER
		itemDetails[1] = c.getString(1); // NAME
		itemDetails[2] = c.getString(2); // CATEGORY
		itemDetails[3] = c.getString(3); // DATESAVED
		itemDetails[4] = c.getString(4); // LASTUPDATED
		itemDetails[5] = c.getString(5); // DESCRIPTION
		itemDetails[6] = c.getString(6); // IMAGECOUNT
		itemDetails[7] = c.getString(7); // IMAGENAMES
		
		Log.d(LOGTAG, "DBHelper : Item Details : ");
		for(int i = 0; i < itemDetails.length; i++)
			Log.d(LOGTAG, itemDetails[i]);
		
		return itemDetails;
	}
	
	public boolean saveDBTOSCard()
	{
		Log.d(LOGTAG, "DBHelper : Saving all DB content to sdcard...");
		
		return false;
	}
}
