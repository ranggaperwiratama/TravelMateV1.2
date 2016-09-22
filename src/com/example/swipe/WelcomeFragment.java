package com.example.swipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class WelcomeFragment extends Fragment {
	View v;
	
	
	
	private ProgressDialog pDialog;

	JSONParser jParser = new JSONParser();


	private static String url_semua_anggota = "http://192.168.56.1/amobi/hotvilla.php";
	
	private static final String TAG_SUKSES = "sukses";
	private static final String TAG_MEMBER = "member";
	public static final String TAG_IDMEM = "id";
	public static final String TAG_NAMA = "nama";
	public static final String TAG_DES = "deskripsi";
	public static final String TAG_HARGA = "harga";
	public static final String TAG_GBR = "gambar";
	public static final String TAG_FAL = "fasilitas";

	String id,nama,harga,des,fasil;

	JSONArray member = null;
	ListView lv;
	TourismSpotAdapter adapter;
	
	
	  
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		v = inflater.inflate(R.layout.welcome, container, false);	
		//new AmbilDataJson().execute();
		
		
	/*	Button pesan = (Button) v.findViewById(R.id.btnpesan);
		pesan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub				
				Bundle b = new Bundle();
				b.putString("hargavilla", harga);
				b.putString("namavilla", nama);
				b.putString("fasilitas", fasil);
				b.putString("deskripsi", des);
				b.putString("idvilla", id);
				Intent i = new Intent(v.getContext(), detailvilla.class);
				i.putExtras(b);
				startActivity(i);
			}
		});*/
		
		return v;
	}
	
/*	class AmbilDataJson extends AsyncTask<String, String, String> {

		*//**
		 * sebelum memulai background thread tampilkan Progress Dialog
		 * *//*
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Mengambil Data Anggota. Silahkan Tunggu...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}*/

		/**
		 * mengambil semua data anggota/member dari url
		 * */
	/*	protected String doInBackground(String... args) {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			JSONObject json = jParser.makeHttpRequest(url_semua_anggota, "GET", params);
			
			Log.d("Semua Anggota: ", json.toString());


			try {
				int sukses = json.getInt(TAG_SUKSES);

				if (sukses == 1) {
					member = json.getJSONArray(TAG_MEMBER);

					for (int i = 0; i < member.length(); i++) {
						JSONObject c = member.getJSONObject(i);

						id = c.getString(TAG_IDMEM);
						nama = c.getString(TAG_NAMA);
						des = c.getString(TAG_DES);
						harga = c.getString(TAG_HARGA);
						fasil = c.getString(TAG_FAL);
							
						HashMap<String, String> map = new HashMap<String, String>();

						map.put(TAG_IDMEM, id);
						map.put(TAG_NAMA, nama);
						map.put(TAG_DES, des);
						map.put(TAG_HARGA, harga);
						map.put(TAG_FAL, fasil);
						//===================
						map.put(TAG_GBR, "no_image");
						//================
					}
				} else {
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}*/

		/**
		 * setelah menyelesaikan background task hilangkan the progress dialog
		 * **/
		/*protected void onPostExecute(String file_url) {
			
			pDialog.dismiss();

			getActivity().runOnUiThread(new Runnable() {
				public void run() {
					if(id.equalsIgnoreCase("1")){
						ImageView i = (ImageView) v.findViewById(R.id.imageViewHot2);
				        i.setImageResource(R.drawable.image0);
					}
					else if(id.equalsIgnoreCase("2")){
						ImageView i = (ImageView) v.findViewById(R.id.imageViewHot2);
				        i.setImageResource(R.drawable.image1);
					}
					else if(id.equalsIgnoreCase("3")){
						ImageView i = (ImageView) v.findViewById(R.id.imageViewHot2);
				        i.setImageResource(R.drawable.image2);
					}
					else if(id.equalsIgnoreCase("4")){
						ImageView i = (ImageView) v.findViewById(R.id.imageViewHot2);
				        i.setImageResource(R.drawable.image4);
					}
					else if(id.equalsIgnoreCase("5")){
						ImageView i = (ImageView) v.findViewById(R.id.imageViewHot2);
				        i.setImageResource(R.drawable.image5);
					}
					else if(id.equalsIgnoreCase("6")){
						ImageView i = (ImageView) v.findViewById(R.id.imageViewHot2);
				        i.setImageResource(R.drawable.image6);
					}
					else if(id.equalsIgnoreCase("7")){
						ImageView i = (ImageView) v.findViewById(R.id.imageViewHot2);
				        i.setImageResource(R.drawable.image7);
					}
					else if(id.equalsIgnoreCase("8")){
						ImageView i = (ImageView) v.findViewById(R.id.imageViewHot2);
				        i.setImageResource(R.drawable.image8);
					}
					else if(id.equalsIgnoreCase("9")){
						ImageView i = (ImageView) v.findViewById(R.id.imageViewHot2);
				        i.setImageResource(R.drawable.image9);
					}
					else if(id.equalsIgnoreCase("10")){
						ImageView i = (ImageView) v.findViewById(R.id.imageViewHot2);
				        i.setImageResource(R.drawable.image10);
					}
					else{
						ImageView i = (ImageView) v.findViewById(R.id.imageViewHot2);
				        i.setImageResource(R.drawable.no_image);
					}
					
					TextView namav = (TextView) v.findViewById(R.id.textFull);
					
					namav.setText(nama);
				}
			});*/

		//}
	
}
