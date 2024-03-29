package com.example.finalproject2;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.widget.Button;

public class ServiceVolumeActivity extends Activity {

	private AudioManager mAudioManager;
	private String mPhoneIsNormal = "Normal";
	private String mPhoneIsVibrate = "Vibrate";
	private String mPhoneIsSilent = "Silent";
	Button normal, vibrate, silent;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_volume);
        
        super.onCreate(savedInstanceState);
        mAudioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        checkIfPhoneIsSilent();
        setButtonClickListener();
        Log.d("SilentModeApp", "This is a test");
        
    }    
    
     private void setButtonClickListener() {
        final TextView txt = (TextView) findViewById(R.id.txt1);	
        final Button toggleButton = (Button)findViewById(R.id.silent);
        toggleButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        	ImageView imageView = (ImageView) findViewById(R.id.phone_icon);
        	Drawable newPhoneImage;
        	
        	if (checkIfPhoneIsSilent() == mPhoneIsNormal) {
        		mAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        		mPhoneIsSilent = mPhoneIsVibrate;
        		toggleButton.setText("Activate Vibrate Mode");
        		txt.setText("Mobile Is In Vibrate Mode");
        		Toast.makeText(getBaseContext(), "Vibrate Mode Activated", Toast.LENGTH_LONG).show();
        		newPhoneImage = getResources().getDrawable(R.drawable.vibration_on);	
    			imageView.setImageDrawable(newPhoneImage);
        		
        	}else if (checkIfPhoneIsSilent() == mPhoneIsSilent) {
        		//change back to normal mode
        		
        		mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        		mPhoneIsSilent = mPhoneIsNormal;
        		toggleButton.setText("Activate Normal Mode");
        		txt.setText("Mobile Is In Normal Mode");
        		Toast.makeText(getBaseContext(), "Normal Mode Activated", Toast.LENGTH_LONG).show();
        		newPhoneImage = getResources().getDrawable(R.drawable.phone_normal);	
    			imageView.setImageDrawable(newPhoneImage);
        	}else
        		{
        			//change to silent mode
        			mAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        			mPhoneIsVibrate = mPhoneIsSilent;
        			toggleButton.setText("Activate Normal Mode");
        			txt.setText("Mobile Is In Silent Mode");
        			Toast.makeText(getBaseContext(), "Silent Mode Activated",Toast.LENGTH_LONG).show();
        			newPhoneImage = getResources().getDrawable(R.drawable.phone_silent);	
        			imageView.setImageDrawable(newPhoneImage);
        		}
        	}
        });
    }
        private String checkIfPhoneIsSilent() {
        	int ringermode = mAudioManager.getRingerMode();
        	if (ringermode == AudioManager.RINGER_MODE_SILENT) {
        		return mPhoneIsSilent ;
        	}
        	else if (ringermode == AudioManager.RINGER_MODE_NORMAL) {
        		return mPhoneIsNormal ;
        	}
        	else{
        		return mPhoneIsVibrate;
        	}
        }
        
        private void toggleUi() {
        	ImageView imageView = (ImageView) findViewById(R.id.phone_icon);
        	Drawable newPhoneImage;
        	if (checkIfPhoneIsSilent() == mPhoneIsSilent){
        		newPhoneImage = getResources().getDrawable(R.drawable.phone_silent);
		        }
        	else if (checkIfPhoneIsSilent() == mPhoneIsNormal){
		    		newPhoneImage = getResources().getDrawable(R.drawable.phone_normal);
		        }  
        	else
		        {
		        		newPhoneImage = getResources().getDrawable(R.drawable.vibration_on);
		        
		        }
        	imageView.setImageDrawable(newPhoneImage);
    
}
@Override      
protected void onResume() {
	super.onResume();
	checkIfPhoneIsSilent();
	toggleUi();
	
}
}