package com.example.finalproject2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.telephony.gsm.SmsMessage.MessageClass;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		GoogleMapFragment GoogleMapFragment = new GoogleMapFragment();
		
		ContactListFragment contactList = new ContactListFragment();
		
		//transaction.add(R.id.fragment2, contactList);
		transaction.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		Intent intent;
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.action_settings:
		    intent = new Intent(this, GoogleMapActivity.class);
			startActivity(intent);
			break;
			
		case R.id.action_ContactList:
		    intent = new Intent(this, contactListActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
		return true;
		
	}

	public void GoogleMapFragment(View v){
		Intent intent = new Intent(getApplicationContext(),GoogleMapFragment.class);
		startActivity(intent);
	}
	
	public void onSelectFagment(View view){
		
		Fragment newFragment;
		GoogleMapActivity googleActivity;
		
		
		
		if(view == findViewById(R.id.btnGoogleMap)){
			Intent intent = new Intent(this, GoogleMapActivity.class);
			startActivity(intent);
			return;
			
		}//else if(view == findViewById(R.id.btnCurrentLocation)){
			//newFragment = new CurrentLocationFragment();}
		
		else if(view == findViewById(R.id.btnContactList)){
			Intent intent = new Intent(this, contactListActivity.class);
			startActivity(intent);
			return;
			
		}else{
			Intent intent = new Intent(this, ServiceVolumeActivity.class);
			startActivity(intent);
			return;
		}
			
	}
	
}
