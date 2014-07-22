package com.example.homework2_resources;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class StateActivity extends Activity{
	private static final String State_Text = "TXT_STATE";
	private TextView txtView = null;
	
	private void generateRandom(){
		Random rd = new Random();
		int randomNum = rd.nextInt();
		txtView.setText(String.valueOf(randomNum));
	}
	
	@Override
	protected void onCreate (Bundle savedIstanceState){
		super.onCreate(savedIstanceState);
		setContentView(R.layout.fragment_state);
		
		txtView = (TextView) findViewById(R.id.textView2);
		generateRandom();
		
		if(savedIstanceState !=null){
			String text = savedIstanceState.getString(State_Text);
			txtView.setText(text);
			
		}
	}
	
	@Override
	protected void onSaveInstanceState (Bundle outState){
		super.onSaveInstanceState(outState);
		
		String previousText = txtView.getText().toString();
		outState.putString(State_Text, previousText);
	}
	
}