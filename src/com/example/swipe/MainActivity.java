package com.example.swipe;

import java.util.Locale;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {


	// used to store app title
	private CharSequence mTitle;
	private MediaPlayer mp;

	
	//private SharedPreferences sharedPreferences;
	SectionsPagerAdapter mSectionsPagerAdapter;

	String id, nama, alamat, saldo;


	ViewPager mViewPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//loadPreferences();

		getActionBar().setTitle("Travel Mate");
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		mp = MediaPlayer.create(getBaseContext(), R.raw.welcome);
		mp.start();
		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		PagerTabStrip strip = (PagerTabStrip) findViewById(R.id.pager_title_strip);
		strip.setTabIndicatorColor(0xFF0000);                     
		
	}


	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			if (position == 0) {
				Fragment fragment = new WelcomeFragment();
				return fragment;
			} else if (position == 2) {
				Fragment fragment = new FindNearby();
				return fragment;
			} else {
				Fragment fragment = new ListTourismSpot();
				return fragment;
			}

		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			}
			return null;
		}

	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;

	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.home :
			Intent i = new Intent(getBaseContext(),MainActivity.class);
			startActivity(i);
			break;
				}
		return true;
	}

}
