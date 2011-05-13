package com.yaseriesapps.closetcatalog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Options extends Activity 
{
	private Button recordBtn, browseBtn, wishlistBtn, exitBtn;
	private String LOGTAG = "ClosetCatalog";
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);
        
        recordBtn = (Button) findViewById(R.id.recordbutton);
        browseBtn = (Button) findViewById(R.id.browsebutton);
        wishlistBtn = (Button) findViewById(R.id.wishlistbutton);
        exitBtn = (Button) findViewById(R.id.exitbutton);
        
        recordBtn.setOnClickListener(recordClickListener);
        browseBtn.setOnClickListener(browseClickListener);
        wishlistBtn.setOnClickListener(wishlistClickListener);
        exitBtn.setOnClickListener(exitClickListener);
        
        Log.d(LOGTAG, "Displayed options activity, and set all listeners");
    }
    
    OnClickListener recordClickListener = new OnClickListener()
    {
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Log.d(LOGTAG, "Starting Record activity");
			Intent recordClickIntent = new Intent("com.yaseriesapps.closetcatalog.RECORD");
			startActivity(recordClickIntent);
		}
	};
	
    OnClickListener browseClickListener = new OnClickListener()
    {
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Intent browseClickIntent = new Intent("com.yaseriesapps.closetcatalog.BROWSE");
			startActivity(browseClickIntent);
		}
	};

    OnClickListener wishlistClickListener = new OnClickListener()
    {
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Intent wishlistClickIntent = new Intent("com.yaseriesapps.closetcatalog.WISHLIST");
			startActivity(wishlistClickIntent);
		}
	};

	OnClickListener exitClickListener = new OnClickListener()
    {
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			Log.d(LOGTAG, "We're done here");
			finish();
		}
	};
	
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionsmenu, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.optionsprefs:
        	Log.d(LOGTAG, "Main Screen : Showing Settings");
        	
        	Intent settingsMenu = new Intent("com.yaseriesapps.closetcatalog.SHOW_SETTINGS");
    		settingsMenu.addCategory("android.intent.category.DEFAULT");
    		startActivity(settingsMenu);
        	
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }

}