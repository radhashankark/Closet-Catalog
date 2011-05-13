package com.yaseriesapps.closetcatalog;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Browse extends Activity 
{
	private String LOGTAG = "ClosetCatalog";
	private ImageView nextItem, prevItem, pictureFrame;
	private TextView pictureFrameText;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse);
        
        initUIComponents();
        
        Log.d(LOGTAG, "Created and displayed the browse activity");
    }
    
    private void initUIComponents()
    {
    	nextItem = (ImageView) findViewById(R.id.browsenext);
        prevItem = (ImageView) findViewById(R.id.browseprev);
        pictureFrame = (ImageView) findViewById(R.id.pictureframe);
        pictureFrameText = (TextView) findViewById(R.id.pictureframetext);
        
    	nextItem.setOnClickListener(nextItemOnClickListener);
        prevItem.setOnClickListener(prevItemOnClickListener);
        pictureFrame.setOnClickListener(pictureFrameOnClickListener);
        
        // pictureFrame.onTouchEvent(event)
    }
    
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.browsemenu, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.browsecategory:
        	Log.d(LOGTAG, "Browsing : Switching category");
            return true;
        case R.id.search:
        	Log.d(LOGTAG, "Browsing : Searching for an item");
            return true;
        case R.id.delete:
        	Log.d(LOGTAG, "Browsing : Deleting the item");
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    private OnClickListener nextItemOnClickListener = new OnClickListener()
    {
		@Override
		public void onClick(View v) 
		{
			// TODO Auto-generated method stub
			Log.d(LOGTAG, "Browsing : Next Item");
		}
	};
	
    private OnClickListener prevItemOnClickListener = new OnClickListener()
    {
		@Override
		public void onClick(View v) 
		{
			// TODO Auto-generated method stub
			Log.d(LOGTAG, "Browsing : Previous Item");
		}
	};

	private OnClickListener pictureFrameOnClickListener = new OnClickListener()
    {
		@Override
		public void onClick(View v) 
		{
			// TODO Auto-generated method stub
			pictureFrameText.setVisibility(TextView.GONE);

			Log.d(LOGTAG, "Browsing : Showing category");
		}
	};
}