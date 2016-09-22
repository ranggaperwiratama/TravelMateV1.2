package com.example.swipe;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
 
public class SplashScreen extends Activity {
	
     public void onAttachedToWindow() {
            super.onAttachedToWindow();
            Window window = getWindow();
            window.setFormat(PixelFormat.RGBA_8888);
        }
    /** Called when the activity is first created. */
     private SharedPreferences sharedPreferences;
     boolean isLogin;
    private static int SPLASH_TIME_OUT = 4000;
    
	public void loadPreferences() {
		sharedPreferences = getSharedPreferences("shared",
				Activity.MODE_PRIVATE);
		if (sharedPreferences != null) {
			isLogin = sharedPreferences.getBoolean("LOGIN", false);
		} else {
			isLogin = false;
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		loadPreferences();
		super.onCreate(savedInstanceState);
		if(isLogin == true)
		{
			setContentView(R.layout.activity_splash);
			StartAnimations();
			new Handler().postDelayed(new Runnable() {
	
				/*
				 * Showing splash screen with a timer. This will be useful when you
				 * want to show case your app logo / company
				 */
	
				@Override
				public void run() {
					// This method will be executed once the timer is over
					// Start your app main activity
					Intent i = new Intent(SplashScreen.this, MainActivity.class);
					startActivity(i);
					finish();
				}
			}, SPLASH_TIME_OUT);
			
		}
		else{
			setContentView(R.layout.activity_splash);
			StartAnimations();
			new Handler().postDelayed(new Runnable() {
	
				/*
				 * Showing splash screen with a timer. This will be useful when you
				 * want to show case your app logo / company
				 */
	
				@Override
				public void run() {
					// This method will be executed once the timer is over
					// Start your app main activity
					Intent i = new Intent(SplashScreen.this, MainActivity.class);
					startActivity(i);
	
					// close this activity
					finish();
				}
			}, SPLASH_TIME_OUT);
		}

	}
	
	 private void StartAnimations() {
	        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
	        anim.reset();
	        LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
	        l.clearAnimation();
	        l.startAnimation(anim);
	 
	       
	        ImageView iv = (ImageView) findViewById(R.id.logo);
	        iv.clearAnimation();
	        iv.startAnimation(anim);
	        
	        
	        
	 
	    }
 
}