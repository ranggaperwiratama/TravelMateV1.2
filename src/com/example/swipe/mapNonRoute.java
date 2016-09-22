package com.example.swipe;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class mapNonRoute extends Activity {
	GoogleMap map;
	//static String type = MainActivity2._transport_type;
	
	static String nama = DetailTourismSpot._nama_spot;
	static String alamat = DetailTourismSpot._alamat_spot;
	private static String url;// 
	
	//private static final String TAG_NAMARESTORAN ="Nama_Restoran";
	private static final String TAG_LAT ="lat_start";
	private static final String TAG_LONG ="long_start";
	private static final String TAG_LAT_SPOT = "lat_spot";
	private static final String TAG_LONG_SPOT = "long_spot";
	private static final String TAG_ALAMAT ="address_trans";
	private static final String TAG_PROVIDER = "provider_name";
	private static final String TAG_PHONE = "phone_trans";
	private static final String TAG_STOPS = "stops_area";
	
	
	String _typeBundle,_idspot;
	List<Marker> markers = new ArrayList<Marker>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapwisata);
       initializeMap();
        
        
		
		//
	//	Log.d("Tes MAsuk","masuk sini dulu chuy");
		Bundle b = getIntent().getExtras();
		_typeBundle = b.getString("typeBundle");
		_idspot = b.getString("idspot");
		
		url = "http://192.168.56.1/amobiapi/range_transport.php?command=findbyType&type="+URLEncoder.encode(_typeBundle)+"&id_spot="+URLEncoder.encode(_idspot);
		Log.d("URL", url);
		JSONAsyncTask _conn_geocode = new JSONAsyncTask(url);
		_conn_geocode.execute();
		//Log.d("Type Map",_typeBundle);
	//	url 
//		map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
//			
////			@Override
////			public void onInfoWindowClick(Marker marker) {
////				// TODO Auto-generated method stub
////				//Intent i = new Intent(getApplicationContext(), MenuMakanan.class);
////				Bundle c = getIntent().getExtras();
////				Bundle b = new Bundle();
////				b.putString("id_recipe", marker.getTitle().toString());
////				b.putString("nama", c.getString("nama").toString());
////				b.putString("alamat", c.getString("alamat").toString());
////			//	i.putExtras(b);
////			//	startActivity(i);
////			}
//		});

	}
	
	 public void initializeMap() {
			// TODO Auto-generated method stub
	    	map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
	     	map.clear();
	    	if(map!=null)
	    	{
	    		map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-7.77988, 110.414075),15));
	    		map.animateCamera(CameraUpdateFactory.zoomTo(10),2000,null);
	    		map.setMyLocationEnabled(true);
	    	}
	    	
	    	
	}
	 
	public void addingMarker(LatLng pos, String namares, String alamat, String spot ) {
			// TODO Auto-generated method stub
		if (spot == "transport"){
	    	map.addMarker(new MarkerOptions().position(pos)
	    			.title(namares)
	    			.snippet(alamat)
	    			.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
		}else if(spot == "spot"){
			Log.d("TESMASUK","MASUK SPOT");
			map.addMarker(new MarkerOptions().position(pos)
	    			.title(namares)
	    			.snippet(alamat)
	    			.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
		}
	    	
	}
	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
//    	Intent i = new Intent(getApplicationContext(), MainActivity2.class);
//    	
//    	
//    	Bundle b = new Bundle();
//    	b.putString("namaspot", nama);
//		b.putString("alamatspot", alamat);
//		i.putExtras(b);
//		startActivity(i);
		finish();
	}
	
	private class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {
		private ProgressDialog dialog;
		String url;
		ArrayList<String> RestoranFix = new ArrayList<String>();
		ArrayList<String> AlamatFix = new ArrayList<String>();
		ArrayList<Double> LatFix, LongFix;
		
		final LatLngBounds.Builder bld = new LatLngBounds.Builder();
		ArrayList<LatLng> posisifix = new ArrayList<LatLng>();
		ArrayList<LatLng> posisispot = new ArrayList<LatLng>();
		int length,lengthSpot;

		
		public JSONAsyncTask(String urlPass) {
			// TODO Auto-generated constructor stub
			url = urlPass;

		}
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
			dialog = new ProgressDialog(mapNonRoute.this);
			dialog.setMessage("Set Lokasi");
			dialog.setCancelable(false);
			dialog.show();
		}
		
		
		@Override
		protected Boolean doInBackground(String... arg0) {
			JSONParser jParser = new JSONParser();
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			
			// TODO Auto-generated method stub
			JSONObject jsonX = jParser.getJSONObjectFromUrl(url);
			try 
			{
				//map.clear();
				JSONArray json = jsonX.getJSONArray("member");	
				length = json.length();
				for (int i = 0; i < json.length(); i++) {
	
					try {
						JSONObject c = json.getJSONObject(i);
						String vRestoran = c.getString(TAG_PROVIDER);
						String vAlamat = c.getString(TAG_ALAMAT);
						Double vLat = c.getDouble(TAG_LAT);
						Double vlong = c.getDouble(TAG_LONG);
						 
						final LatLng position = new LatLng(vLat, vlong);
						posisifix.add(position);
						RestoranFix.add(vRestoran);
						AlamatFix.add(vAlamat);
						
						
						

						
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				JSONArray jsonA = jsonX.getJSONArray("spot");	
				lengthSpot = jsonA.length();
				Log.d("LENGTH",String.valueOf(lengthSpot));
				for (int i = 0; i < jsonA.length(); i++) {
	
					try {
						JSONObject c = jsonA.getJSONObject(i);
						Double vLat = c.getDouble(TAG_LAT_SPOT);
						Double vlong = c.getDouble(TAG_LONG_SPOT);
						
						final LatLng position = new LatLng(vLat, vlong);
						posisispot.add(position);	
						
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			} 
			catch (JSONException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
		@Override
		protected void onPostExecute(Boolean result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			 if (dialog.isShowing())
				 dialog.dismiss();
			 for(int i=0;i<length;i++)
			 { 
				 bld.include(posisifix.get(i));
				 addingMarker(posisifix.get(i),RestoranFix.get(i),AlamatFix.get(i),"transport"); 
			 }
			 for(int i=0;i<lengthSpot;i++){
				 bld.include(posisispot.get(i));
				 addingMarker(posisispot.get(i),RestoranFix.get(i),"","spot"); 
			 }
			         
			 
			
			
			
		}
		
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.menu_utama, menu);
//		return true;
//	}

	
	
//    @Override
//    public void onBackPressed() {
//    	// TODO Auto-generated method stub
//    	Intent i = new Intent(getApplicationContext(), Login.class);
//		startActivity(i);
//		finish();
//    }
}
