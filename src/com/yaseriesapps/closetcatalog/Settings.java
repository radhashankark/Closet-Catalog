package com.yaseriesapps.closetcatalog;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.Preference.OnPreferenceClickListener;
import android.util.Log;

public class Settings extends PreferenceActivity
{
	private final String LOGTAG = "ClosetCatalog";
	Preference clearDBPref, exportItemsPref;
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        
        addPreferencesFromResource(R.xml.settings);
        
        clearDBPref = (Preference) findPreference("clear_db");
        exportItemsPref = (Preference) findPreference("export_items");
        
        clearDBPref.setOnPreferenceClickListener(clearDBClickListener);
        exportItemsPref.setOnPreferenceClickListener(exportItemsClickListener);
    }
	
	OnPreferenceClickListener exportItemsClickListener = new OnPreferenceClickListener()
    {
		@Override
		public boolean onPreferenceClick(Preference preference)
		{
			Log.d(LOGTAG, "Settings : Exporting all items to sdcard; Pref Key : " + preference.getKey());
			return true;
		}
	};
	
	OnPreferenceClickListener clearDBClickListener = new OnPreferenceClickListener()
    {
		@Override
		public boolean onPreferenceClick(Preference preference)
		{
			Log.d(LOGTAG, "Settings : Clearing DB; Pref Key : " + preference.getKey());
			return true;
		}
	};
}
