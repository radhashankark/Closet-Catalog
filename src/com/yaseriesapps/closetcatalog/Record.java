package com.yaseriesapps.closetcatalog;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Record extends Activity 
{
	private String LOGTAG = "ClosetCatalog";
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        
        Log.d(LOGTAG, "Created and displayed the record activity");
    }
    
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.recordmenu, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.recordaddimage:
        	Log.d(LOGTAG, "Recording : Adding a picture");
            return true;
        case R.id.recordsave:
        	Log.d(LOGTAG, "Recording : Saving the item");
            return true;
        case R.id.recordimport:
        	Log.d(LOGTAG, "Recording : Importing an image");
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }

}