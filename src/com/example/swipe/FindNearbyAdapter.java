package com.example.swipe;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FindNearbyAdapter extends BaseAdapter {
	private Activity activity;
	private ArrayList<HashMap<String, String>> data;
	private static LayoutInflater inflater = null;
	
	public FindNearbyAdapter (Activity a, ArrayList<HashMap<String, String>> d){
		activity = a;
		data = d;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.list_row, null);
		
//		TextView deskripsi = (TextView) vi.findViewById(R.id.idmem);
//		TextView nama = (TextView) vi.findViewById(R.id.nama); 
//		TextView harga = (TextView) vi.findViewById(R.id.alamat); 
//		TextView id = (TextView) vi.findViewById(R.id.idvilla);
//		ImageView thumb_image = (ImageView) vi.findViewById(R.id.gambar); 
		
//		HashMap<String, String> daftar_berita = new HashMap<String, String>();
//		daftar_berita = data.get(position);
	
//		deskripsi.setText(daftar_berita.get(FindNearby.TAG_INFO));
//		nama.setText(daftar_berita.get(FindNearby.TAG_NAMA));
//		harga.setText(daftar_berita.get(FindNearby.TAG_ALAMAT));
//		id.setText(daftar_berita.get(FindNearby.TAG_IDSPOT));
		return vi;
	}

}
