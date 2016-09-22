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

public class TypeTransportNonRuteAdapter extends BaseAdapter {

	private Activity activity;
	private ArrayList<HashMap<String, String>> data;
	private static LayoutInflater inflater = null;
	//public ImageLoader imageLoader;

	public TypeTransportNonRuteAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
		activity = a;
		data = d;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//imageLoader=new ImageLoader(activity.getApplicationContext());
	}

	public int getCount() {
		return data.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.list_row, null);

	//	TextView deskripsi = (TextView) vi.findViewById(R.id.idmem);
		TextView type = (TextView) vi.findViewById(R.id.nama); 
//		TextView harga = (TextView) vi.findViewById(R.id.alamat); 
		//TextView fasilitas = (TextView) vi.findViewById(R.id.fasilitas);
	//	TextView id = (TextView) vi.findViewById(R.id.idvilla);
	//	ImageView thumb_image = (ImageView) vi.findViewById(R.id.gambar); 
		
		HashMap<String, String> daftar_berita = new HashMap<String, String>();
		daftar_berita = data.get(position);
	
		type.setText(daftar_berita.get(TransportNonRute.TAG_TYPE));
	//	nama.setText(daftar_berita.get(listvilla.TAG_NAMA));
	//.setText(daftar_berita.get(listvilla.TAG_ALAMAT));
		//fasilitas.setText(daftar_berita.get(listvilla.TAG_FAL));
	//	id.setText(daftar_berita.get(listvilla.TAG_IDSPOT));
		//imageLoader.DisplayImage(daftar_berita.get(listvilla.TAG_FOTO), thumb_image);
		/*if(daftar_berita.get(listvilla.TAG_IDMEM).equalsIgnoreCase("1")){
			thumb_image.setImageResource(R.drawable.a);
		}
		else if(daftar_berita.get(listvilla.TAG_IDMEM).equalsIgnoreCase("2")){
			thumb_image.setImageResource(R.drawable.b);
		}
		else if(daftar_berita.get(listvilla.TAG_IDMEM).equalsIgnoreCase("3")){
			thumb_image.setImageResource(R.drawable.c);
		}
		else if(daftar_berita.get(listvilla.TAG_IDMEM).equalsIgnoreCase("4")){
			thumb_image.setImageResource(R.drawable.e);
		}
		else if(daftar_berita.get(listvilla.TAG_IDMEM).equalsIgnoreCase("5")){
			thumb_image.setImageResource(R.drawable.f);
		}
		else if(daftar_berita.get(listvilla.TAG_IDMEM).equalsIgnoreCase("6")){
			thumb_image.setImageResource(R.drawable.g);
		}
		else if(daftar_berita.get(listvilla.TAG_IDMEM).equalsIgnoreCase("7")){
			thumb_image.setImageResource(R.drawable.h);
		}
		else if(daftar_berita.get(listvilla.TAG_IDMEM).equalsIgnoreCase("8")){
			thumb_image.setImageResource(R.drawable.i);
		}
		else if(daftar_berita.get(listvilla.TAG_IDMEM).equalsIgnoreCase("9")){
			thumb_image.setImageResource(R.drawable.j);
		}
		else if(daftar_berita.get(listvilla.TAG_IDMEM).equalsIgnoreCase("10")){
			thumb_image.setImageResource(R.drawable.k);
		}
		else{
			thumb_image.setImageResource(R.drawable.no_image);
		}*/
		return vi;
	}
}
