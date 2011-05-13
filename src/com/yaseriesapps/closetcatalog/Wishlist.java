package com.yaseriesapps.closetcatalog;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Wishlist extends Activity 
{
	private String LOGTAG = "ClosetCatalog";
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wishlist);
        
        Log.d(LOGTAG, "Created and displayed the wishlist activity");
    }
    
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.wishlistmenu, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.wishlistsave:
        	Log.d(LOGTAG, "Wishlist : Saving item");
            return true;
        case R.id.wishlistsearch:
        	Log.d(LOGTAG, "Wishlist : Searching for an item");
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}