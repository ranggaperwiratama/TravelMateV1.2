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
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class ListTourismSpot extends ListFragment {
	View v;
	
	private ProgressDialog pDialog;

	JSONParser jParser = new JSONParser();

	ArrayList<HashMap<String, String>> memberList;

	private static String url_semua_anggota = "http://10.0.3.2/AmobiAPI/tourism_spot.php?command=tampil";
//	private static String url_semua_anggota = "http://192.168.234.1/amobiapi/tourism_spot.php?command=tampil";
	
	private static final String TAG_SUKSES = "sukses";
	private static final String TAG_MEMBER = "member";
	public static final String TAG_IDSPOT = "id_spot";
	public static final String TAG_NAMA = "name_spot";
	public static final String TAG_INFO = "info_spot";
	public static final String TAG_ALAMAT = "address_spot";
	//public static final String TAG_FOTO = "foto";
	public static final String TAG_FAL = "fasilitas";

	String id,nama,alamat,info;

	JSONArray member = null;
	ListView lv;
	TourismSpotAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		v = inflater.inflate(R.layout.wisata, container, false);
        
		
		
		return v;
	}
	
	@Override
	public void onResume() {
	  //onResume happens after onStart and onActivityCreate
	  new AmbilDataJson().execute();
	  memberList = new ArrayList<HashMap<String, String>>();
		
		lv = getListView();
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String nama = ((TextView) view.findViewById(R.id.nama)).getText().toString();
				String alamat = ((TextView) view.findViewById(R.id.alamat)).getText().toString();
				//String id_spot = ((TextView) view.findViewById(R.id.idmem)).getText().toString();
				String id_spot = ((TextView) view.findViewById(R.id.idvilla)).getText().toString();
				
					Bundle b = new Bundle();
					b.putString("namaspot", nama);
					b.putString("alamatspot", alamat);
					/*b.putString("fasilitas", fas);
					b.putString("deskripsi", des);*/
					b.putString("idspot",id_spot);
					//Log.d("IDSPOT", String.valueOf(id));
					Intent i = new Intent(v.getContext(), MainActivity2.class);
					i.putExtras(b);
					startActivity(i);
				
			}
		});
	  super.onResume() ; 
	}
	
	class AmbilDataJson extends AsyncTask<String, String, String> {

		/**
		 * sebelum memulai background thread tampilkan Progress Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Loading...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		/**
		 * mengambil semua data anggota/member dari url
		 * */
		protected String doInBackground(String... args) {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			JSONObject json = jParser.makeHttpRequest(url_semua_anggota, "GET", params);
			
			Log.d("Semua Anggota: ", json.toString());


			try {
				int sukses = json.getInt(TAG_SUKSES);

				if (sukses == 1) {
					member = json.getJSONArray(TAG_MEMBER);

					for (int i = 0; i < member.length(); i++) {
						JSONObject c = member.getJSONObject(i);

						id = c.getString(TAG_IDSPOT);
						nama = c.getString(TAG_NAMA);
						info = c.getString(TAG_INFO);
						alamat = c.getString(TAG_ALAMAT);
						//fasil = c.getString(TAG_FAL);
						//foto = c.getString(TAG_FOTO);
							
						HashMap<String, String> map = new HashMap<String, String>();

						map.put(TAG_IDSPOT, id);
						map.put(TAG_NAMA, nama);
						map.put(TAG_INFO, info);
						map.put(TAG_ALAMAT, alamat);
						//map.put(TAG_FAL, fasil);
						//===================
						//map.put(TAG_FOTO, "http://192.168.56.1/amobi/images/"+foto);
						//================
						memberList.add(map);
					}
				} else {
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}

		/**
		 * setelah menyelesaikan background task hilangkan the progress dialog
		 * **/
		protected void onPostExecute(String file_url) {
			
			pDialog.dismiss();

			getActivity().runOnUiThread(new Runnable() {
				public void run() {
					
					SetListViewAdapter(memberList);
					
				}
			});

		}

	}
	
	public void SetListViewAdapter(ArrayList<HashMap<String, String>> berita) {
		adapter = new TourismSpotAdapter(getActivity(), berita);
		lv.setAdapter(adapter);
	}
	
}
