package com.somitsolutions.android.training.keypad;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements OnClickListener, OnLongClickListener{
	
	Button mButton1, mButton2, mButton3,mButton4, mButton5, mButton6,mButton7,mButton8,mButton9,mButton0,mButtonCall,mButtonClear;
	EditText mDisplay; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = (Button)findViewById(R.id.button1);
        mButton2 = (Button)findViewById(R.id.button2);
        mButton3 = (Button)findViewById(R.id.button3);
        mButton4 = (Button)findViewById(R.id.button4);
        mButton5 = (Button)findViewById(R.id.button5);
        mButton6 = (Button)findViewById(R.id.button6);
        mButton7 = (Button)findViewById(R.id.button7);
        mButton8 = (Button)findViewById(R.id.button8);
        mButton9 = (Button)findViewById(R.id.button9);
        mButton0 = (Button)findViewById(R.id.button11);
        mButtonCall = (Button)findViewById(R.id.buttonCall);
        mButtonClear = (Button)findViewById(R.id.button10);
        mDisplay = (EditText)findViewById(R.id.editText1);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        mButton8.setOnClickListener(this);
        mButton9.setOnClickListener(this);
        mButton0.setOnClickListener(this);
        mButtonCall.setOnClickListener(this);
        mButtonClear.setOnClickListener(this);
        mButtonClear.setOnLongClickListener(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View paramView) {
		// TODO Auto-generated method stub
		if (paramView.equals(mButton1)){
			mDisplay.append("1");
		}
		if (paramView.equals(mButton2)){
			mDisplay.append("2");
		}
		if (paramView.equals(mButton3)){
			mDisplay.append("3");
		}
		if (paramView.equals(mButton4)){
			mDisplay.append("4");
		}
		if (paramView.equals(mButton5)){
			mDisplay.append("5");
		}
		if (paramView.equals(mButton6)){
			mDisplay.append("6");
		}
		if (paramView.equals(mButton7)){
			mDisplay.append("7");
		}
		if (paramView.equals(mButton8)){
			mDisplay.append("8");
		}
		if (paramView.equals(mButton9)){
			mDisplay.append("9");
		}
		if (paramView.equals(mButton0)){
			mDisplay.append("0");
		}
		if (paramView.equals(mButtonCall)){
			String PhoneNum = mDisplay.getText().toString();
			 //Intent callIntent = new Intent(Intent.ACTION_DIAL);
			 Intent callIntent = new Intent(Intent.ACTION_CALL);
	         callIntent.setData(Uri.parse("tel:"+Uri.encode(PhoneNum.trim())));
	         callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	         startActivity(callIntent);  
		}
		if (paramView.equals(mButtonClear)){
			String temp = mDisplay.getText().toString();
			if(!temp.equals("")){
				String toBeDisplayedAfterRemovingOneDigit = temp.substring(0, temp.length()-1);
				mDisplay.setText(toBeDisplayedAfterRemovingOneDigit);
			}
		}
	}


	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.equals(mButtonClear)){
			mDisplay.getText().clear();
		}
		return false;
	}
    
}
