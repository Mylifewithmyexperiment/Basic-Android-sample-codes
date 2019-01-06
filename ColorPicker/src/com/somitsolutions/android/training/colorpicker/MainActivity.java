package com.somitsolutions.android.training.colorpicker;



import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.app.AlertDialog;

public class MainActivity extends Activity implements OnClickListener{
	
	private SeekBar redSeekBar;
	private SeekBar greenSeekBar;
	private SeekBar blueSeekBar;
	private EditText redEditText;
	private EditText greenEditText;
	private EditText blueEditText;
	private RelativeLayout mainLayout;
	
	private int redProgress = 0;
	private int greenProgress = 0;
	private int  blueProgress = 0;
	
	private int redValue = 0;
	private int greenValue = 0;
	private int blueValue = 0;
	
	Button okBtn;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	        
		mainLayout = (RelativeLayout)findViewById(R.id.mainLayout);
	        okBtn = (Button)findViewById(R.id.button1);
	        
	        //Seekbars
	        redSeekBar = (SeekBar)findViewById(R.id.seekBar1);
	        greenSeekBar = (SeekBar)findViewById(R.id.seekBar2);
	        blueSeekBar = (SeekBar)findViewById(R.id.seekBar3);
	        
	        //EditTexts
	        redEditText = (EditText)findViewById(R.id.editText1);
	        greenEditText = (EditText)findViewById(R.id.editText2);
	        blueEditText = (EditText)findViewById(R.id.editText3);
	      
	        
	        redSeekBar.setOnSeekBarChangeListener(OnSeekBarProgress);
	        greenSeekBar.setOnSeekBarChangeListener(OnSeekBarProgress);
	        blueSeekBar.setOnSeekBarChangeListener(OnSeekBarProgress);
	        
	        //okBtn.setBackgroundDrawable(Utility.resizeImage(this,R.drawable.picture, 32, 32));
	        okBtn.setOnClickListener(this);
	        
	        //set the maximum of seekbars as 100%
	        redSeekBar.setMax(254);
	        greenSeekBar.setMax(254);
	        blueSeekBar.setMax(254);
	    }
	    
	    OnSeekBarChangeListener OnSeekBarProgress =
	    	new OnSeekBarChangeListener() {

	    	public void onProgressChanged(SeekBar s, int progress, boolean touch){
	    	
	        	if(touch){
	    	
	        	if(s == redSeekBar){
	    		
	    		redProgress = progress;
	    		redEditText.setText(Integer.toString(progress*100/254));
	    	}

	        	if(s == greenSeekBar ){
	    		greenProgress = progress;
	    		greenEditText.setText(Integer.toString(greenProgress*100/254));
	    	}

	        	if(s == blueSeekBar ){
	    		blueProgress = progress;
	    		blueEditText.setText(Integer.toString(blueProgress*100/254));
	    	}

	        	int color = Color.rgb(redProgress, greenProgress, blueProgress);
	    	
	        	mainLayout.getRootView().setBackgroundColor(color);

	    	}
	        	
	    	}

	    	public void onStartTrackingTouch(SeekBar s){

	    	}

	    	public void onStopTrackingTouch(SeekBar s){

	    	}
	    	};
	    	
	    	@Override
	    	public void onClick(View v){
	    	
	    	if(v == okBtn) {
	    	
	    		String redText = redEditText.getText().toString();
	    		String greenText = greenEditText.getText().toString();
	    		String blueText = blueEditText.getText().toString();
	    		
	    		   		
	    		if(!("".equals(redText))){
	    			try{
	    				redValue = Integer.parseInt(redText);
	    			}
	    			catch(NumberFormatException e){	
	    			}
	    		}
	    		
	    		else
	    			redValue = 0;
	    		
	    		if(!("".equals(greenText))){
	    			try {
	    				greenValue = Integer.parseInt(greenText);
	    			}
	    			catch(NumberFormatException e){	
	    			}
	    		}
	    		else
	    			greenValue = 0;
	    		
	    		if(!("".equals(blueText))){
	    			try {
	    				blueValue = Integer.parseInt(blueText);
	    			}
	    			catch(NumberFormatException e){	
	    			}
	    		}
	    		else
	    			blueValue = 0;
	    		
	    		if( redValue>=0 && redValue<=100) {
	    			redProgress = 254*redValue/100;
	    			redSeekBar.setProgress(redProgress);
	    		}
	    		
	    		else {
	    				new AlertDialog.Builder(this)
	    				.setTitle("Alert!")
	    				.setMessage("Please enter a value between 0 and 100 for Red...")
	    				.setNeutralButton("Close", new DialogInterface.OnClickListener() {
	    				public void onClick(DialogInterface dlg, int sumthin) {
	    				// do nothing � it will close on its own
	    				}
	    				})
	    				.show(); 
	    				}
	    		
	    	
		    	if( greenValue>=0 && greenValue<=100) {
					greenProgress = 254*greenValue/100;
					greenSeekBar.setProgress(greenProgress);
				}
				
				else {
						new AlertDialog.Builder(this)
						.setTitle("Alert!")
						.setMessage("Please enter a value between 0 and 100 for Green...")
						.setNeutralButton("Close", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dlg, int sumthin) {
						// do nothing � it will close on its own
						}
						})
						.show(); 
						}
				
		    	
		    	if( blueValue>=0 && blueValue<=100) {
					blueProgress = 254*blueValue/100;
					blueSeekBar.setProgress(blueProgress);
				}
				
				else {
						new AlertDialog.Builder(this)
						.setTitle("Alert!")
						.setMessage("Please enter a value between 0 and 100 for Blue...")
						.setNeutralButton("Close", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dlg, int sumthin) {
						// do nothing � it will close on its own
						}
						})
						.show();
						}
		    	
		    	int color = Color.rgb(redProgress, greenProgress, blueProgress);
		     	mainLayout.getRootView().setBackgroundColor(color);
				}	
	}

	    	@Override
	        public boolean onCreateOptionsMenu(Menu menu) {
	            // Inflate the menu; this adds items to the action bar if it is present.
	            getMenuInflater().inflate(R.menu.main, menu);
	            return true;
	        }
	

}
