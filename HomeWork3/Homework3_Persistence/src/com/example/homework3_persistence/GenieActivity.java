package com.example.homework3_persistence;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

public class GenieActivity extends ActionBarActivity {

	private ToggleButton b1 = null;
	private ToggleButton b2 = null;
	private ToggleButton b3 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_genie);
        
        b1 = (ToggleButton) findViewById(R.id.toggleButton1);
        b2 = (ToggleButton) findViewById(R.id.toggleButton2);
        b3 = (ToggleButton) findViewById(R.id.toggleButton3);
        
        //SharedPreferences preferences = getSharedPreferences(GenieActivity.class.getName(), MODE_PRIVATE);
       SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        b1.setEnabled(sharedPref.getBoolean(b1.getText().toString(), true));
        b2.setEnabled(sharedPref.getBoolean(b2.getText().toString(), true));
        b3.setEnabled(sharedPref.getBoolean(b3.getText().toString(), true));
    }

    private void savePreference(View view){
    	//SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
    	SharedPreferences sharedPref = getSharedPreferences(GenieActivity.class.getName(), MODE_PRIVATE);
    	Editor editor = sharedPref.edit();
    	editor.putBoolean((((ToggleButton) view).getText().toString()), ((ToggleButton) view).isEnabled());
    	editor.commit();
    }
    
    public void ButtonOnClick(View view){
    	((ToggleButton)view).setEnabled(false);
    	savePreference(view);
    }
	@Override
	public void onDestroy(){
		savePreference(b1);
		savePreference(b2);
		savePreference(b3);
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.genie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_genie, container, false);
            return rootView;
        }
   }

}
